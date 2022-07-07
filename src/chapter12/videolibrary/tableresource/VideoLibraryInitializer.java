package chapter12.videolibrary.tableresource;

import chapter12.videolibrary.initializer.*;

import java.sql.SQLException;

public class VideoLibraryInitializer {
    Actors actors;
    Directors directors;
    Countries countries;
    CountryMovieLink countryMovieLink;
    Movies movies;
    MovieActors movieActors;
    MovieDirection movieDirection;

    public VideoLibraryInitializer() throws SQLException, ClassNotFoundException {
        actors = new Actors();
        directors = new Directors();
        movies = new Movies();
        countries = new Countries();
        countryMovieLink = new CountryMovieLink();
        movieActors = new MovieActors();
        movieDirection = new MovieDirection();
    }

    public void createTablesAndForeignKeys() throws SQLException {
        actors.createTable();
        movies.createTable();
        movieActors.createTable();
        directors.createTable();
        movieDirection.createTable();
        countries.createTable();
        countryMovieLink.createTable();

        actors.createUniqueIndex();
        countries.createUniqueIndex();
        movies.createUniqueIndex();
        directors.createUniqueIndex();

        countryMovieLink.createForeignKeys();
        movieActors.createForeignKeys();
        movieDirection.createForeignKeys();
    }
}