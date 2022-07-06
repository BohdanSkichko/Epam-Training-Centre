package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class Countries extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS countries" +
            "(Id serial primary key, name VARCHAR NOT NULL)";
    private final static String SQL_UNIQUE_KEY = "create unique index unique_key_idx on countries (name)";

    public Countries() {
        super("countries");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE, "table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }

    @Override
    public void createUniqueIndex() throws SQLException {
        super.executeSqlStatement(SQL_UNIQUE_KEY);
    }
}
