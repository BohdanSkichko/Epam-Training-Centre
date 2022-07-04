package chapter12.videolibrary.models;

import java.time.LocalDate;


public class Actor extends Entity {

    private String name;
    private String surname;
    private LocalDate birthday;
    private Movie movie;

    public Actor() {

    }

    public Actor( String name, String surname, LocalDate birthday) {

        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public void setFilm(Movie movie) {
        this.movie = movie;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Movie getFilm() {
        return movie;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "Actor" +
                name + " " + surname + " " + birthday;
    }

}
