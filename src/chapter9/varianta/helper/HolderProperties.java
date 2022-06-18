package chapter9.varianta.helper;

public enum HolderProperties {
    FILE_INPUT("fileInput"),
    FILE_OUTPUT("fileOutput");


    public String getPath() {
        return GreatStream.path(path);
    }

    private final String path;

    HolderProperties(String path) {
        this.path = path;
    }
}

