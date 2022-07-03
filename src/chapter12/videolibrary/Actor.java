package chapter12.videolibrary;

import java.sql.Date;
import java.time.LocalDate;


public class Actor extends Entity {
    private final String name;
    private final String surname;
    private final Date birthday;


    public Actor( String name, String surname, Date birthday) {
        this.name = name;
        this.surname = surname;
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
        return "Actor" +
                name + " " + surname + " " + birthday;
    }
}
