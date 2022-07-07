package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class CountryMovieLink extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS country_movie_link " +
            "(Id serial primary key, country_id INTEGER NOT NULL, movie_id INTEGER NOT NULL)";
    private final static String SQL_CREATE_KEY_MOVIE = " ALTER TABLE country_movie_link ADD FOREIGN KEY (movie_id) " +
            "REFERENCES movies(id)";
    private final static String SQL_CREATE_KEY_COUNTRY = "ALTER TABLE country_movie_link ADD FOREIGN KEY (country_id) " +
            "REFERENCES countries(id)";

    public CountryMovieLink() {
        super("country_movie_link");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE,"table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_KEY_MOVIE, "create new key:  movie_id -> movies(id)");
        super.executeSqlStatement(SQL_CREATE_KEY_COUNTRY, "create new key:  country_id -> countries(id)");
    }

    @Override
    public void createUniqueIndex() throws SQLException {

    }
}
