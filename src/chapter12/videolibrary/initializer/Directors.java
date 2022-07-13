package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class Directors extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS directors (id serial PRIMARY KEY," +
            "name VARCHAR(50) NOT NULL," +
            "surname VARCHAR(50) NOT NULL, birthday DATE NOT NULL)";
    private final static String SQL_UNIQUE_KEY = "CREATE unique index directors_idx ON directors (name, surname, birthday)";

    public Directors() {
        super("directors");
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
