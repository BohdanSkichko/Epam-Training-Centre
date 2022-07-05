package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class Participants extends BaseTable implements TableOperations {

    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS actors (Id serial primary key," +
            "Name VARCHAR(50) NOT NULL, " +
            "Surname VARCHAR(50) NOT NULL, Birthday DATE NOT NULL)";

    public Participants() {
        super("participants");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE + tableName);

    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
