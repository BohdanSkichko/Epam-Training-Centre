package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class MoviesDirectors extends BaseTable implements TableOperations{
    public MoviesDirectors() {
        super("movies_directors");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS movies_directors (movies_id INTEGER NOT NULL," +
                " directors_id INTEGER NOT NULL)");
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(" ALTER TABLE movies_directors ADD FOREIGN KEY (movies_id) REFERENCES movies(id)",
                "create new key:  movies_id -> movies.id");
        super.executeSqlStatement(" ALTER TABLE movies_directors ADD FOREIGN KEY (directors_id) REFERENCES directors(id)",
                "create new key:  directors_id -> directors.id");
    }

}
