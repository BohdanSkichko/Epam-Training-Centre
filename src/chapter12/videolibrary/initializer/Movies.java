package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class Movies extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movies (id serial PRIMARY KEY," +
            "title VARCHAR(50) NOT NULL, release_date DATE NOT NULL)";
    private final static String SQL_UNIQUE_KEY = "CREATE unique index movies_idx ON movies (title, release_date)";

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
