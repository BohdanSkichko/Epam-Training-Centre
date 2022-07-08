package chapter12.videolibrary.initializer;

import chapter12.videolibrary.DAO.DBConnector;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class BaseTableCreator implements Closeable {
    Connection connection;
    String tableName;

   public BaseTableCreator(String tableName) {
        this.tableName = tableName;
        this.connection = DBConnector.getConnection();
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing SQL connection!");
        }
    }

    protected void executeSqlStatement(String sql, String description) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        if (description != null)
            System.out.println(description);
    }

    void executeSqlStatementVariant(String sql, String description) throws SQLException {
        try (Statement statement = Objects.requireNonNull(DBConnector.getConnection()).createStatement()) {
            assert statement != null;
            statement.execute(sql);
        }
        if (description != null)
            System.out.println(description);
    }

    protected void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

}

