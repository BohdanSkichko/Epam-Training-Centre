package helper.properties;

public enum PropertiesDBEnum {
    USER("db.user"),
    PASSWORD("db.password"),
    URL("db.url");
    public final String part;

    public String getPart() {
        return part;
    }

    PropertiesDBEnum(String part) {
        this.part = part;
    }

}
