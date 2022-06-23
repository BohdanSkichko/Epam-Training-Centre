package chapter9.varianta.textreditor;
import helper.properties.IOHelper;
import helper.properties.PropertiesEnum;

public class SubstringDeleter {
    public void delete(String someSubstring) {
        IOHelper ioHelper = new IOHelper();
        String result = ioHelper.readFromFile(PropertiesEnum.INPUT_FILE.getPath())
                .replaceAll(someSubstring,"");
        ioHelper.writeToFile(PropertiesEnum.OUTPUT_FILE.getPath(), result);
    }
}