package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class MoviesActors extends BaseTable implements TableOperations {
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movies_actors " +
            "(movies_id INTEGER NOT NULL, actors_id INTEGER NOT NULL)";
    private final static String SQL_CREATE_KEY = "ALTER TABLE movies_actors ADD FOREIGN KEY " +
            "(actors_id) REFERENCES actors(id), + create new key:  actors_id -> actors.id";

    public MoviesActors() {
        super("movies_actors");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_TABLE);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(SQL_CREATE_KEY);
        super.executeSqlStatement(" ALTER TABLE movies_actors ADD FOREIGN KEY (movies_id) REFERENCES movies(id)",
                "create new key:  movies_id -> movies.id");
    }

}
