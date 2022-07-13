package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class Countries extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS countries" +
            "(id serial PRIMARY KEY, name VARCHAR NOT NULL)";
    private final static String SQL_UNIQUE_KEY = "CREATE unique index countries_idx ON countries (name)";

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
