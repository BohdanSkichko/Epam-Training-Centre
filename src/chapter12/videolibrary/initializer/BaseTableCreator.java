package chapter12.videolibrary.initializer;

import chapter12.videolibrary.DAO.DBConnector;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTableCreator  {
    String tableName;

    public BaseTableCreator(String tableName) {
        this.tableName = tableName;
    }

    protected void executeSqlStatement(String sql, String description) throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        try (connection;
             statement) {
            statement.execute(sql);
            if (description != null)
                System.out.println(description);
        }
    }

    void executeSqlStatementVariant(String sql, String description) throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        try (connection;
             statement) {
            statement.execute(sql);
        }
        if (description != null)
            System.out.println(description);
    }

    protected void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }
}

