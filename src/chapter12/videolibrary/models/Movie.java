package chapter12.videolibrary.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Entity {
    private String name;
    private LocalDate releaseDate;
    private String country;
    private List<Actor> actors;

    public Movie() {

    }

    public Movie(String name, LocalDate releaseDate, String country) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.country = country;
        actors = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCountry() {
        return country;
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
