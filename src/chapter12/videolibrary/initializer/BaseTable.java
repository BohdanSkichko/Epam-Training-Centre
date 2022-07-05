package chapter12.videolibrary.initializer;

import chapter12.DBConnector;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable implements Closeable {
    Connection connection;
    String tableName;

    BaseTable(String tableName) {
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

    void executeSqlStatement(String sql, String description) throws SQLException {
//        reopenConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        if (description != null)
            System.out.println(description);
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DBConnector.getConnection();
        }
    }
}

