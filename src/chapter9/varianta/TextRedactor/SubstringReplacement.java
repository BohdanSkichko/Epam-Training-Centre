package chapter9.varianta.TextRedactor;

import chapter9.varianta.helper.HolderProperties;
import chapter9.varianta.helper.ReadAndWriteProperties;

public class SubstringReplacement {
    public void replace(String remove, String newSubstring) {
        ReadAndWriteProperties readAndWriteProperties = new ReadAndWriteProperties();
        String result = readAndWriteProperties.read(HolderProperties.FILE_INPUT.getPath())
                .replaceAll(remove, newSubstring);
        readAndWriteProperties.writeContentToFile(HolderProperties.FILE_OUTPUT.getPath(), result);

    }
}
