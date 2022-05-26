package chapter4.varianta.task19;

public class Photo  {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Photo(String name) {
        this.name = name;
    }
}
