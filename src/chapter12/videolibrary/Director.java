package chapter12.videolibrary;

import java.sql.Date;
import java.time.LocalDate;

public class Director extends Entity {
    private final String name;
    private final String surname;
    private final LocalDate birthday;


    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
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

    public Director(int id, String name, String surname, LocalDate birthday) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
}
