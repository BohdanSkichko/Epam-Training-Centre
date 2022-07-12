package chapter12.videolibrary.models;

import java.util.ArrayList;
import java.util.List;

public class Country extends Entity {
    private String name;
    private List<Movie> movies = new ArrayList<>();

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(int id, String name) {
        super(id);
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Country(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public Country(int id, String name, List<Movie> movies) {
        super(id);
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
