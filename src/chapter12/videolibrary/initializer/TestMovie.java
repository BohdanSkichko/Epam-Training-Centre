package chapter12.videolibrary.initializer;

import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Country;
import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TestMovie {

    public static Movie getTestMovie() {
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

        Movie movie = new Movie("movie", LocalDate.of(2022, 11, 1), countries, actors, directors);
        return movie;
    }
}
