package chapter12.videolibrary.models;

public class Country extends Entity{
    private String name;

    private Country(String name) {
        this.name = name;
    }

    public Country(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
