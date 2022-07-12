package chapter12;

import chapter12.videolibrary.DAO.ActorDAO;
import chapter12.videolibrary.DAO.MovieDao;
import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Country;
import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws SQLException {
//
//        try {
//            VideoLibraryInitializer videoLibraryInitializer = new VideoLibraryInitializer();
//            videoLibraryInitializer.createTablesAndForeignKeys();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        List<Country> countries = new ArrayList<>();
        countries.add(new Country("USA"));
        countries.add(new Country("Canada"));
        countries.add(new Country("Ukraine"));

        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor("Jack", "Nicholson", LocalDate.of(1937, Month.APRIL, 22)));
        actors.add(new Actor("Tom", "Hanks", LocalDate.of(1956, Month.JULY, 9)));
        actors.add(new Actor("Leonardo", "DiCaprio", LocalDate.of(1974, Month.NOVEMBER, 11)));
        actors.add(new Actor("Morgan", "Freeman", LocalDate.of(1937, Month.JUNE, 1)));
        actors.add(new Actor("Johnny", "Depp", LocalDate.of(1963, Month.JUNE, 9)));
        actors.add(new Actor("Quentin", "Tarantino", LocalDate.of(1963, Month.MAY, 27)));


        List<Director> directors = new ArrayList<>();
        directors.add(new Director("Johnny", "Depp", LocalDate.of(1963, Month.JUNE, 9)));
        directors.add(new Director("Tom", "Hanks", LocalDate.of(1956, Month.JULY, 9)));
        directors.add(new Director("Quentin", "Tarantino", LocalDate.of(1963, Month.MAY, 27)));
        directors.add(new Director("Jack", "Nicholson", LocalDate.of(1937, Month.APRIL, 22)));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Brave", LocalDate.of(1997, Month.MAY, 10)));
        movies.add(new Movie("Band of Brothers", LocalDate.of(2001, Month.SEPTEMBER, 9)));
        movies.add(new Movie("Django Unchained", LocalDate.of(2012, Month.DECEMBER, 11)));
        movies.add(new Movie("The Terror", LocalDate.of(1963, Month.JUNE, 17)));
        movies.add(new Movie("Titanic", LocalDate.of(1997, Month.DECEMBER, 14)));
        movies.add(new Movie("The Shawshank Redemption", LocalDate.of(1994, Month.SEPTEMBER, 22)));

        List<Movie> movies1 = new ArrayList<>();
        Movie movie = new Movie("movie12", LocalDate.of(2014, 11, 23), countries, actors, directors);
        MovieDao movieDao = new MovieDao();
//       movieDao.insert(movie);
//       movieDao.deleteIfReleaseMoreYearsAgo(7);
//        ActorDAO actorDAO = new ActorDAO();
//        System.out.println(actorDAO.findAllInMovie(movie));
//        System.out.println(actorDAO.findAllIfQuantityMovieOver(1));
//        System.out.println(actorDAO.findAllDirectors());
//        movieDao.delete(movie);
//        movieDao.findMoviesBetweenYears(new Date(190, Calendar.MARCH,11),new Date(212, Calendar.FEBRUARY,12));
//        System.out.println(movieDao.findMoviesBetweenYears(LocalDate.of(1990, 1, 11), LocalDate.of(2011, 1, 12)));
//        System.out.println(movieDao.findAll());
    }

}

