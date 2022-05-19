package chapter4.task1.variantb;

public class Directory extends File {
   private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory(String name) {
        super();
        this.name = name;


    }
}
