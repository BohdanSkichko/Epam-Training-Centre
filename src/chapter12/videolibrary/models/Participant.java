package chapter12.videolibrary.models;

import java.time.LocalDate;

public class Participate extends Entity{
    private String name;
    private String surname;
    private LocalDate birthday;
    private Movie movie;

    public Participate(String name, String surname, LocalDate birthday, Movie movie) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.movie = movie;
    }

    public Participate(int id, String name, String surname, LocalDate birthday, Movie movie) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.movie = movie;
    }
}
