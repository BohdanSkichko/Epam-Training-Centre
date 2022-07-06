package chapter12.videolibrary.models;

import java.util.List;

public class Country extends Entity{
    private String name;
    private Movie movie;


    public Country(String name) {
        this.name = name;
    }

    public Country(int id, String name) {
        super(id);
        this.name = name;
    }

    public Country(String name, Movie movie) {
        this.name = name;
        this.movie = movie;
    }

    public Country(int id, String name, Movie movie) {
        super(id);
        this.name = name;
        this.movie = movie;
    }
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
