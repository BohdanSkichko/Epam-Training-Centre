package chapter12.videolibrary;

import chapter12.videolibrary.TableOperations;

import java.sql.SQLException;

public class MoviesActors extends BaseTable implements TableOperations {

    public MoviesActors() {
        super("movies_actors");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS movies_actors (movies_id INTEGER NOT NULL, " +
                "actors_id INTEGER NOT NULL)");
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(" ALTER TABLE movies_actors ADD FOREIGN KEY (actors_id) REFERENCES actors(id)",
                "create new key:  actors_id -> actors.id");
        super.executeSqlStatement(" ALTER TABLE movies_actors ADD FOREIGN KEY (movies_id) REFERENCES movies(id)",
                "create new key:  movies_id -> movies.id");
    }

}
