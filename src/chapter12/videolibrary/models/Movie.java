package chapter12.videolibrary.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Entity {
    private String title;
    private LocalDate releaseDate;
    private List<Country> countries = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();
    private List<Director> directors = new ArrayList<>();

    public Movie() {

    }

    public Movie(String title, LocalDate releaseDate, List<Country> countries, List<Actor> actors, List<Director> directors) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.countries = countries;
        this.actors = actors;
        this.directors = directors;
    }

    public Movie(int id, String title, LocalDate releaseDate, List<Country> country, List<Actor> actors, List<Director> directors) {
        super(id);
        this.title = title;
        this.releaseDate = releaseDate;
        this.countries = country;
        this.actors = actors;
        this.directors = directors;
    }

    public Movie(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    public void addActor(Actor actor) {
        actor.setMovie(this);
        actors.add(actor);
    }

    public void addCountry(Country country) {
        country.setMovie(this);
        countries.add(country);
    }

    public void addDirector(Director director) {
        director.setMovie(this);
        directors.add(director);
    }

    public List<Country> getCountry() {
        return countries;
    }

    public void setCountry(List<Country> country) {
        this.countries = country;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }


    @Override
    public String toString() {
        return "Film{" +
                "name='" + title + '\'' +
                ", actors=" + actors +
                ", releaseDate=" + releaseDate +
                ", country='" + countries + '\'' +
                '}';
    }

}
