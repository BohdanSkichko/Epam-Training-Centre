package chapter12.videolibrary.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Entity {
    private String name;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    private LocalDate releaseDate;
    private List<Country> country;
    private List<Actor> actors;

    public Movie() {

    }

    public Movie(int id, String name, LocalDate releaseDate) {
        super(id);
        this.name = name;
        this.releaseDate = releaseDate;
        country = new ArrayList<>();
        actors = new ArrayList<>();

    }

    public Movie(String name, LocalDate releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
        country = new ArrayList<>();
        actors = new ArrayList<>();

    }

    public Movie(String name, LocalDate releaseDate, List<Country> country, List<Actor> actors) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.country = country;
        this.actors = actors;
    }

    public Movie(int id, String name, LocalDate releaseDate, List<Country> country, List<Actor> actors) {
        super(id);
        this.name = name;
        this.releaseDate = releaseDate;
        this.country = country;
        this.actors = actors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    public void addActor(Actor actor) {
        actor.setFilm(this);
        actors.add(actor);
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getName() {
        return name;
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
                "name='" + name + '\'' +
                ", actors=" + actors +
                ", releaseDate=" + releaseDate +
                ", country='" + country + '\'' +
                '}';
    }

}
