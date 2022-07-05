package chapter12.videolibrary.models;

import java.time.LocalDate;

public class Participant extends Entity{
    private String name;
    private String surname;
    private LocalDate birthday;
    private Movie movie;

    public Participant(String name, String surname, LocalDate birthday, Movie movie) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.movie = movie;
    }

    public Participant(int id, String name, String surname, LocalDate birthday, Movie movie) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.movie = movie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Movie getMovie() {
        return movie;
    }


}
