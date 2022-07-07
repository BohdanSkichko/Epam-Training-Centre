package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class MovieDirection extends BaseTableCreator implements TableOperations {
    public MovieDirection() {
        super("movies_direction");
    }

    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movie_direction (Id serial primary key, " +
            "movie_id INTEGER NOT NULL, director_id INTEGER NOT NULL)";
    private final static String SQL_CREATE_KEY_MOVIE = "ALTER TABLE movie_direction ADD FOREIGN KEY (movie_id) " +
            "REFERENCES movies(id)";
    private final static String SQL_CREATE_KEY_DIRECTOR = "ALTER TABLE movie_direction ADD FOREIGN KEY (director_id)" +
            "REFERENCES directors(id)";

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE,"table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_KEY_MOVIE, "create new key:  movie_id -> movies(id)");
        super.executeSqlStatement(SQL_CREATE_KEY_DIRECTOR, "create new key:  director_id -> directors(id)");
    }

    @Override
    public void createUniqueIndex() throws SQLException {

    }

}
