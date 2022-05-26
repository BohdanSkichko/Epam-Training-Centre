package chapter4.varianta.task12;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    private final List<File> files = new ArrayList<>();

    public Directory(String name, Directory parent) {
        super(name, parent);
    }


    @Override
    void showContent() {

        for (File f : files)
            System.out.println(f.getName() + " ");
    }


    static Directory createNew(String name, Directory parent) {
        return new Directory(name, parent);

    }

    public void addFile(File f) {
        files.add(f);
    }


    public List<File> getFiles() {
        return files;
    }


}

