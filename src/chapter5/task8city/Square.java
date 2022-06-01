package chapter5.task8city;

public class Square {
    private final String name;
    private final int number;

    public Square(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return
                name + " " +
                        number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
