package chapter4.task1.variantb;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    private final List<File> files = new ArrayList<>();

    public Directory(String name, File parent) {
        super(name, parent);
    }


    @Override
    void showContent() {

        for (File f : files)
            System.out.print(getName(f));
    }

    @Override
    public File renameTo(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        return new Directory(name,this.getParent());
    }

    static Directory createNew(String name, File parent) {
        return new Directory(name, parent);

    }

    public void addFiles(File f) {
        files.add(f);
    }


    public List<File> getFiles() {
        return files;
    }


}

