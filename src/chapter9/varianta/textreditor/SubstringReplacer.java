package chapter9.varianta.textreditor;

import chapter9.varianta.helper.IOHelper;
import chapter9.varianta.helper.PropertiesEnum;

public class SubstringReplacer {
    public void replace(String oldSubstring, String newSubstring) {
        IOHelper ioHelper = new IOHelper();
        String result = ioHelper.readFromFile(PropertiesEnum.FILE_INPUT.getPath())
                .replaceAll(oldSubstring, newSubstring);
        ioHelper.writeToFile(PropertiesEnum.FILE_OUTPUT.getPath(), result);

    }
}
