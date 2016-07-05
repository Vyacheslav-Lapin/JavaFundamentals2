package com.epam.trainings.java.fundamentals.jdbc.cp;

import com.epam.courses.jf.common.Private;
import com.epam.courses.jf.common.ReflectUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.epam.courses.jf.common.PropertyMap.getAndRemove;
import static java.lang.Integer.parseInt;

public interface ConnectionPool {

    BlockingQueue<Connection> getConnectionQueue();
    Collection<Connection> getGivenAwayConQueue();

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

//    ConnectionPool(String dbPropertiesFilePath) throws ConnectionPoolException {
//
//        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
//        this.driverName = dbResourceManager.getValue(DBParameter.DB_DRIVER);
//        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
//        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
//
//        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
//
//        try {
//            this.poolSize = Integer.parseInt(dbResourceManager
//                    .getValue(DBParameter.DB_POLL_SIZE));
//        } catch (NumberFormatException e) {
//            poolSize = 5;
//        }
//
//        Locale.setDefault(Locale.ENGLISH);
//
//        try {
//            Class.forName(driverName);
//            givenAwayConQueue = new ArrayBlockingQueue<>(poolSize);
//            connectionQueue = new ArrayBlockingQueue<>(poolSize);
//            for (int i = 0; i < poolSize; i++) {
//                Connection connection = DriverManager.getConnection(url, user,
//                        password);
//                PooledConnection pooledConnection = new PooledConnection(
//                        connection, connectionQueue, givenAwayConQueue);
//                connectionQueue.add(pooledConnection);
//            }
//        } catch (SQLException e) {
//            throw new ConnectionPoolException("SQLException in ConnectionPool", e);
//        } catch (ClassNotFoundException e) {
//            throw new ConnectionPoolException("Can't find database driver class", e);
//        }
//    }

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
                IntStream.range(0, poolSize)
                        .mapToObj(value -> createConnection(url, properties))
                        .collect(Collectors.toSet()));

        Collection<Connection> takenConnections = new HashSet<>(poolSize);

        return new ConnectionPool() {
            @Override
            public BlockingQueue<Connection> getConnectionQueue() {
                return freeConnections;
            }

            @Override
            public Collection<Connection> getGivenAwayConQueue() {
                return takenConnections;
            }
        };
    }

    @Private
    static Connection createConnection(String url, Properties properties) {
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException("SQLException in ConnectionPoolFactory", e);
        }
    }

    default Connection getConnection() {
        try {
            Connection connection = getConnectionQueue().take();
            getGivenAwayConQueue().add(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error connecting to the data source.", e);
        }
    }
}