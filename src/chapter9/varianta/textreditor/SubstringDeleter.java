package chapter9.varianta.textreditor;
import chapter9.varianta.helper.IOHelper;
import chapter9.varianta.helper.PropertiesEnum;

public class SubstringDeleter {
    public void delete(String someSubstring) {
        IOHelper ioHelper = new IOHelper();
        String result = ioHelper.readFromFile(PropertiesEnum.FILE_INPUT.getPath())
                .replaceAll(someSubstring,"");
        ioHelper.writeToFile(PropertiesEnum.FILE_OUTPUT.getPath(), result);
    }
}