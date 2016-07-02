package com.epam.trainings.java.fundamentals.jdbc.cp;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
// ^\s{4}(\w+\s([^\s\(]+\([^\)]*\)) throws [^;]*);$
// default $1 {\n        return toSrc().$2;\n    }
public interface ConnectionWrapper extends Connection, Wrapper<Connection> {

    @Override
    default Statement createStatement() throws SQLException {
        return toSrc().createStatement();
    }

    @Override
    default PreparedStatement prepareStatement(String sql) throws SQLException {
        return toSrc().prepareStatement(String sql);
    }

    @Override
    default CallableStatement prepareCall(String sql) throws SQLException {
        return toSrc().prepareCall(String sql);
    }

    @Override
    default String nativeSQL(String sql) throws SQLException {
        return toSrc().nativeSQL(String sql);
    }

    @Override
    default void setAutoCommit(boolean autoCommit) throws SQLException {
        return toSrc().setAutoCommit(boolean autoCommit);
    }

    @Override
    default boolean getAutoCommit() throws SQLException {
        return toSrc().getAutoCommit();
    }

    @Override
    default void commit() throws SQLException {
        return toSrc().commit();
    }

    @Override
    default void rollback() throws SQLException {
        return toSrc().rollback();
    }

    @Override
    default void close() throws SQLException {
        return toSrc().close();
    }

    @Override
    default boolean isClosed() throws SQLException {
        return toSrc().isClosed();
    }

    @Override
    default DatabaseMetaData getMetaData() throws SQLException {
        return toSrc().getMetaData();
    }

    @Override
    default void setReadOnly(boolean readOnly) throws SQLException {
        return toSrc().setReadOnly(boolean readOnly);
    }

    @Override
    default boolean isReadOnly() throws SQLException {
        return toSrc().isReadOnly();
    }

    @Override
    default void setCatalog(String catalog) throws SQLException {
        return toSrc().setCatalog(String catalog);
    }

    @Override
    default String getCatalog() throws SQLException {
        return toSrc().getCatalog();
    }

    @Override
    default void setTransactionIsolation(int level) throws SQLException {
        return toSrc().setTransactionIsolation(int level);
    }

    @Override
    default int getTransactionIsolation() throws SQLException {
        return toSrc().getTransactionIsolation();
    }

    @Override
    default SQLWarning getWarnings() throws SQLException {
        return toSrc().getWarnings();
    }

    @Override
    default void clearWarnings() throws SQLException {
        return toSrc().clearWarnings();
    }

    @Override
    default Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return toSrc().createStatement(int resultSetType, int resultSetConcurrency);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return toSrc().prepareStatement(String sql, int resultSetType, int resultSetConcurrency);
    }

    @Override
    default CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return toSrc().prepareCall(String sql, int resultSetType, int resultSetConcurrency);
    }

    @Override
    default Map<String, Class<?>> getTypeMap() throws SQLException {
        return toSrc().getTypeMap();
    }

    @Override
    default void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        toSrc().setTypeMap(map);
    }

    @Override
    default void setHoldability(int holdability) throws SQLException {
        return toSrc().setHoldability(int holdability);
    }

    @Override
    default int getHoldability() throws SQLException {
        return toSrc().getHoldability();
    }

    @Override
    default Savepoint setSavepoint() throws SQLException {
        return toSrc().setSavepoint();
    }

    @Override
    default Savepoint setSavepoint(String name) throws SQLException {
        return toSrc().setSavepoint(String name);
    }

    @Override
    default void rollback(Savepoint savepoint) throws SQLException {
        return toSrc().rollback(Savepoint savepoint);
    }

    @Override
    default void releaseSavepoint(Savepoint savepoint) throws SQLException {
        return toSrc().releaseSavepoint(Savepoint savepoint);
    }

    @Override
    default Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return toSrc().createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return toSrc().prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability);
    }

    @Override
    default CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return toSrc().prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return toSrc().prepareStatement(String sql, int autoGeneratedKeys);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return toSrc().prepareStatement(String sql, int[] columnIndexes);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return toSrc().prepareStatement(String sql, String[] columnNames);
    }

    @Override
    default Clob createClob() throws SQLException {
        return toSrc().createClob();
    }

    @Override
    default Blob createBlob() throws SQLException {
        return toSrc().createBlob();
    }

    @Override
    default NClob createNClob() throws SQLException {
        return toSrc().createNClob();
    }

    @Override
    default SQLXML createSQLXML() throws SQLException {
        return toSrc().createSQLXML();
    }

    @Override
    default boolean isValid(int timeout) throws SQLException {
        return toSrc().isValid(int timeout);
    }

    @Override
    default void setClientInfo(String name, String value) throws SQLClientInfoException {
        return toSrc().setClientInfo(String name, String value);
    }

    @Override
    default void setClientInfo(Properties properties) throws SQLClientInfoException {
        return toSrc().setClientInfo(Properties properties);
    }

    @Override
    default String getClientInfo(String name) throws SQLException {
        return toSrc().getClientInfo(String name);
    }

    @Override
    default Properties getClientInfo() throws SQLException {
        return toSrc().getClientInfo();
    }

    @Override
    default Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return toSrc().createArrayOf(String typeName, Object[] elements);
    }

    @Override
    default Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return toSrc().createStruct(String typeName, Object[] attributes);
    }

    @Override
    default void setSchema(String schema) throws SQLException {
        return toSrc().setSchema(String schema);
    }

    @Override
    default String getSchema() throws SQLException {
        return toSrc().getSchema();
    }

    @Override
    default void abort(Executor executor) throws SQLException {
        return toSrc().abort(Executor executor);
    }

    @Override
    default void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        return toSrc().setNetworkTimeout(Executor executor, int milliseconds);
    }

    @Override
    default int getNetworkTimeout() throws SQLException {
        return toSrc().getNetworkTimeout();
    }

    @Override
    default <T> T unwrap(Class<T> iface) throws SQLException {
        return toSrc().unwrap(iface);
    }

    @Override
    default boolean isWrapperFor(Class<?> iface) throws SQLException {
        return toSrc().isWrapperFor(iface);
    }
}