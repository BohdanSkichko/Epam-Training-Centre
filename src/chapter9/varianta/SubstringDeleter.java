package chapter9.varianta;


import chapter9.varianta.helper.PropertiesHolder;
import chapter9.varianta.helper.ReadAndWriteProperties;

public class SubstringDeleter {
    public void delete(String someSubstring) {
        ReadAndWriteProperties readAndWriteProperties = new ReadAndWriteProperties();
        String result = readAndWriteProperties.read("C:\\input.txt")
                .replaceAll(someSubstring,"");
        readAndWriteProperties.writeContentToFile("C:\\output.txt", result);
    }
}