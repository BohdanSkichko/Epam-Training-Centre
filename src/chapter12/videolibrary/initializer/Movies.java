package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class Movies extends BaseTable implements TableOperations{
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movies (Id serial primary key," +
            "Title VARCHAR(50) NOT NULL, Release_data DATE NOT NULL)";

    public Movies() {
        super("movies");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE,"table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }

}
