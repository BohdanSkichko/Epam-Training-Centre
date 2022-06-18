package chapter9.varianta;


import chapter9.varianta.helper.GreatStream;
import chapter9.varianta.helper.HolderProperties;
import chapter9.varianta.helper.ReadAndWriteProperties;

public class SubstringDeleter {
    public void delete(String someSubstring) {
        ReadAndWriteProperties readAndWriteProperties = new ReadAndWriteProperties();
        String result = readAndWriteProperties.read(HolderProperties.FILE_INPUT.getPath())
                .replaceAll(someSubstring,"");
        readAndWriteProperties.writeContentToFile(HolderProperties.FILE_OUTPUT.getPath(), result);
    }
}