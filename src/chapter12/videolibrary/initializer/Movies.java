package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class Movies extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movies (Id serial primary key," +
            "title VARCHAR(50) NOT NULL, release_data DATE NOT NULL)";
    private final static String SQL_UNIQUE_KEY = "create unique index movies_idx on movies (title, release_data)";

    public Movies() {
        super("movies");
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
