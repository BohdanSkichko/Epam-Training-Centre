package chapter12.videolibrary.models;

import java.time.LocalDate;

public class Director extends Entity {
    private  String name;
    private  String surname;
    private  LocalDate birthday;

    public Director(int id, String name, String surname, LocalDate birthday) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
    public Director(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
    public Director(){

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
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}
