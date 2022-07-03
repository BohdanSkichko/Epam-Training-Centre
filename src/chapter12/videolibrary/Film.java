package chapter12.videolibrary;


import java.sql.Date;
import java.util.ArrayList;


public class Film extends Entity {
    private final String name;
    private final ArrayList<Actor> actors;
    private final Date releaseDate;
    private final String country;


    public String getName() {
        return name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getCountry() {
        return country;
    }


    public Film(String name, ArrayList<Actor> actors, Date releaseDate, String country) {
        this.name = name;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.country = country;
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
