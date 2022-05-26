package chapter4.varianta.task12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class File {
    private String name;
    private Directory parent;

    public File(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public File() {

    }

    void renameTo(String name) {
        this.name = name;
    }

    public void delete() {
        this.getParent().getFiles().remove(this);
    }

    public String getPathName() {
        List<String> pathname = new ArrayList<>();
        pathname.add(name);
        Directory tempParent = parent;
        while (tempParent != null) {
            pathname.add(tempParent.getName());
            tempParent = tempParent.getParent();
        }
        Collections.reverse(pathname);
       return String.join("\\", pathname);
    }

    abstract void showContent();

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }


    @Override
    public String toString() {
        return
                name;

    }
}
