package helper.properties;

public enum PropertiesEnum {
    INPUT_FILE("inputFile"),
    OUTPUT_FILE("outputFile"),
    POEM ("poem"),
    EMPTY ("empty"),
    DIRECTORY ("directory"),
    ;



    public String getPath() {
        return PropertiesReader.getProperties(path);
    }

    private final String path;

    PropertiesEnum(String path) {
        this.path = path;
    }
}

