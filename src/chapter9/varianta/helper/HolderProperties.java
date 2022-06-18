package chapter9.varianta.helper;

public enum HolderProperties {
    INPUT_PATH("C:\\input.txt"),
    OUT_PATH("C:\\output.txt");

    private final String path;

    public String getPath() {
        return path;
    }

    HolderProperties(String path) {
        this.path = path;
    }

}

