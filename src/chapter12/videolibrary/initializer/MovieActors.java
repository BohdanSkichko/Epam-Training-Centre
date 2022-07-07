package chapter12.videolibrary.initializer;

import chapter12.videolibrary.tableresource.TableOperations;

import java.sql.SQLException;

public class MovieActors extends BaseTableCreator implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movie_actors " +
            "(Id serial primary key, movie_id INTEGER NOT NULL, actor_id INTEGER NOT NULL)";
    private final static String SQL_CREATE_KEY_MOVIE = " ALTER TABLE movie_actors ADD FOREIGN KEY (movie_id) " +
            "REFERENCES movies(id)";
    private final static String SQL_CREATE_KEY_ACTOR = "ALTER TABLE movie_actors ADD FOREIGN KEY (actor_id) " +
            "REFERENCES actors(id)";


    public MovieActors() {
        super("movie_actors");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE,"table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_KEY_MOVIE, "create new key:  actor_id -> actors(id)");
        super.executeSqlStatement(SQL_CREATE_KEY_ACTOR, "create new key:  movie_id -> movies(id)");
    }

    @Override
    public void createUniqueIndex() throws SQLException {

    }

}
