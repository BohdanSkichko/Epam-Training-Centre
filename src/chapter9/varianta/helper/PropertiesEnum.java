package chapter9.varianta.helper;

public enum PropertiesEnum {
    INPUT_FILE("inputFile"),
    OUTPUT_FILE("outputFile");


    public String getPath() {
        return PropertiesReader.getProperties(path);
    }

    private final String path;

    PropertiesEnum(String path) {
        this.path = path;
    }
}

