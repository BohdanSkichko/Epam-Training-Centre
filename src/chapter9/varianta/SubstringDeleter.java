package chapter9.varianta;


import chapter9.varianta.helper.HolderProperties;
import chapter9.varianta.helper.ReadAndWriteProperties;

public class SubstringDeleter {
    public void delete(String someSubstring) {
        ReadAndWriteProperties readAndWriteProperties = new ReadAndWriteProperties();
        String result = readAndWriteProperties.read(HolderProperties.INPUT_PATH.getPath("fileInput"))
                .replaceAll(someSubstring,"");
        readAndWriteProperties.writeContentToFile(HolderProperties.OUT_PATH.getPath("fileOutput"), result);
    }
}