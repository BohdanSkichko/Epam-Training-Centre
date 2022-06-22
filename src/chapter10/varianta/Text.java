package chapter10.varianta;

import helper.helper.IOHelper;
import helper.helper.PropertiesEnum;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Text {
    public HashMap<String, Integer> count(File content) {
        IOHelper ioHelper = new IOHelper();
        HashMap<String, Integer> words = new HashMap<>();
        String withoutPunctuation = ioHelper.readFromFile(content.getAbsolutePath())
                .replaceAll("[.!?\\-]", " ");
        StringTokenizer stringTokenizer = new StringTokenizer(withoutPunctuation, " \n");
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            if (!words.containsKey(nextToken)) {
                words.put(nextToken, 0);
            }
            words.put(nextToken, words.get(nextToken) + 1);
        }
        return words;
    }

    public static void main(String[] args) {
        Text text = new Text();
        System.out.println(text.count(new File(PropertiesEnum.POEM.getPath())));
    }
}
