package chapter9.varianta.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GreatInputStream {
    static String CONFIG_PROPERTIES = "config.properties";
    public static InputStream load() {
        try (InputStream input = GreatInputStream.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {
            Properties properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties.load(input);
            properties.getProperty("fileInput");
            return input;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
