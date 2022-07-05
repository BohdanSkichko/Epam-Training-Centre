package chapter12.videolibrary.initializer;

import java.sql.SQLException;

public class VideoLibraryInitializer {
    Actors actors;
    Directors directors;
    Movies movies;
    MoviesActors moviesActors;
    MoviesDirectors moviesDirectors;

    public VideoLibraryInitializer() throws SQLException, ClassNotFoundException {
        actors = new Actors();
        directors = new Directors();
        movies = new Movies();
        moviesActors = new MoviesActors();
        moviesDirectors = new MoviesDirectors();
    }

public void createTablesAndForeignKeys() throws SQLException {
    actors.createTable();
    movies.createTable();
    moviesActors.createTable();
    directors.createTable();
    moviesDirectors.createTable();

    moviesActors.createForeignKeys();
    moviesDirectors.createForeignKeys();
}
}
