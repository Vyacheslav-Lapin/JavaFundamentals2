package com.epam.trainings.java.fundamentals.jdbc.cp;

import com.epam.courses.jf.common.Private;
import com.epam.courses.jf.common.ReflectUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.courses.jf.common.PropertyMap.getAndRemove;
import static java.lang.Integer.parseInt;

public interface ConnectionPool extends AutoCloseable {

    BlockingQueue<Connection> getConnectionQueue();

    static ConnectionPool create(String dbPropertiesFilePath) {
        try (InputStream propertyFileInputStream = new FileInputStream(dbPropertiesFilePath)) {
            return create(propertyFileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ConnectionPool create(InputStream propertyFileInputStream) {
        final Properties properties = new Properties();
        try {
            properties.load(propertyFileInputStream);
            return create(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ConnectionPool create(Properties properties) {
        assert properties.containsKey("url");
        assert properties.containsKey("poolSize");
        return create(getAndRemove(properties, "url"), parseInt(getAndRemove(properties, "poolSize")), properties);
    }

    default void executeScript(String prepareFilePath) {
        executeScript(Paths.get(prepareFilePath));
    }

    default void executeScript(Path path) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            final String[] sqls = Files.lines(path)
                    .collect(Collectors.joining()).split(";");

            Arrays.stream(sqls)
                    .forEach(s -> {
                        try {
                            statement.addBatch(s);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });

            statement.executeBatch();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ConnectionPool create(String url, int poolSize, Properties properties) {
        assert properties.containsKey("user");
        assert properties.containsKey("password");
        assert properties.containsKey("driver");
        assert properties.size() == 3; // Nothing before this 3 keys is in *.properties file

        ReflectUtils.loadClass(getAndRemove(properties, "driver"), "Can't find database driver class");

        BlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<>(poolSize);

        freeConnections.addAll(
                Stream.generate(() -> createConnection(url, properties, freeConnections))
                        .limit(poolSize)
                        .collect(Collectors.toSet()));

        return new ConnectionPool() {
            @Override
            public BlockingQueue<Connection> getConnectionQueue() {
                return freeConnections;
            }

            @Override
            public void close() throws Exception {
                for (int i = 0; i < poolSize; i++)
                    ((PooledConnection) freeConnections.take()).reallyClose();
            }
        };
    }

    @Private
    static Connection createConnection(String url,
                                       Properties properties,
                                       BlockingQueue<Connection> freeConnections) {
        try {
            return PooledConnection.create(DriverManager.getConnection(url, properties), freeConnections);
        } catch (SQLException e) {
            throw new RuntimeException("SQLException in ConnectionPoolFactory", e);
        }
    }

    default Connection getConnection() {
        try {
            return getConnectionQueue().take();
        } catch (InterruptedException e) {
            throw new RuntimeException("Error connecting to the data source.", e);
        }
    }

    default int size() {
        return getConnectionQueue().size();
    }
}