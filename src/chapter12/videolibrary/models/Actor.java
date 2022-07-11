package chapter12.videolibrary.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Actor extends Entity {

    private String name;
    private String surname;
    private Date birthday;
    private List<Movie> movie = new ArrayList<>();

    public Actor(String name, String surname, LocalDate birthday, List<Movie> movie) {
        this.name = name;
        this.surname = surname;
        this.birthday = Date.valueOf(birthday);
        this.movie = movie;
    }

    public Actor(int id, String name, String surname, LocalDate birthday, List<Movie> movie) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = Date.valueOf(birthday);
        this.movie = movie;
    }

    public Actor() {

    }

    public Actor(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = Date.valueOf(birthday);
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return
                name + " " + surname + " " + birthday;
    }

}
