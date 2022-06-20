package chapter9.varianta.helper;

public enum PropertiesEnum {
    FILE_INPUT("fileInput"),
    FILE_OUTPUT("fileOutput");


    public String getPath() {
        return PropertiesReader.getProperties(path);
    }

    private final String path;

    PropertiesEnum(String path) {
        this.path = path;
    }
}

