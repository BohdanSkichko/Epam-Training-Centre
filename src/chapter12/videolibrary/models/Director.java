package chapter12.videolibrary.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class Director extends Entity {
    private String name;
    private String surname;
    private Date birthday;
    private List<Movie> movies = new ArrayList<>();

    public Director(int id, String name, String surname, LocalDate birthday, List<Movie> movies) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = java.sql.Date.valueOf(birthday);
        this.movies = movies;
    }

    public Director(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = Date.valueOf(birthday);
    }


    public Director() {

    }
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}
