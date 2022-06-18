package chapter9.varianta.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GreatStream {

    static String CONFIG_PROPERTIES = "config.properties";

    public static String path(String getProperty) {
        try (InputStream input = GreatStream.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {
            Properties properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties.load(input);
            return properties.getProperty(getProperty);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
