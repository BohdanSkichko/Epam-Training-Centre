package chapter4.task1.variantb;

public abstract class File {
    private String name;
    private File parent;

    public File(String name, File parent) {
        this.name = name;
        this.parent = parent;
    }

    public File() {

    }


    abstract void showContent();
//    public abstract String[] list(File f);
//    public abstract boolean delete(File f);


    public abstract File renameTo(String name);




    public String getName(File f) {
        return name;
    }

    public File getParent() {
        return parent;
    }


    @Override
    public String toString() {
        return
                 name;

    }
}
