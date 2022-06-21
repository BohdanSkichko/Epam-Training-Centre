package chapter9.varianta.textreditor;
import chapter9.varianta.helper.IOHelper;
import chapter9.varianta.helper.PropertiesEnum;

public class SubstringDeleter {
    public void delete(String someSubstring) {
        IOHelper ioHelper = new IOHelper();
        String result = ioHelper.readFromFile(PropertiesEnum.INPUT_FILE.getPath())
                .replaceAll(someSubstring,"");
        ioHelper.writeToFile(PropertiesEnum.OUTPUT_FILE.getPath(), result);
    }
}