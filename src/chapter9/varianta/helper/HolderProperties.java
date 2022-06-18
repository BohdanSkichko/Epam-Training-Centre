package chapter9.varianta.helper;

public enum HolderProperties {
    INPUT_PATH("input"),
    OUT_PATH("output");

    public String getPath(String getProperty) {
        return GreatStream.path(getProperty);
    }

    HolderProperties(String keyPath) {
    }


}

