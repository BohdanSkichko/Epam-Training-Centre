package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class Directors extends BaseTable implements TableOperations{
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS directors (Id serial primary key," +
            " Name VARCHAR(50) NOT NULL," +
            "Surname VARCHAR(50) NOT NULL, Birthday DATE NOT NULL)";
    public Directors() {
        super("directors");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE,"table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
