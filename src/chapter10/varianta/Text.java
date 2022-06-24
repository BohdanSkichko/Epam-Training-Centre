package chapter10.varianta;

import helper.io.IOHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Text {
    private static final String REMOVE_PUNCTUATION = "[.!?\\-]";
    private static final String REPLACEMENT_FOR_PUNCTUATION = " ";
    private static final String WORD_SPLIT = "\\s+";

    private String getText(File file) {
        IOHelper ioHelper = new IOHelper();
        return ioHelper.readFromFile(file.getAbsolutePath())
                .replaceAll(REMOVE_PUNCTUATION, REPLACEMENT_FOR_PUNCTUATION);

    }

    private String[] getWords(String someText) {
        return someText.split(WORD_SPLIT);
    }

    public Map<String, Integer> getWordsCount(String[] words) {
        Map<String, Integer> word = new HashMap<>();
        for (String uniqueWord : words) {
            if (!word.containsKey(uniqueWord)) {
                word.put(uniqueWord, 1);
            } else word.put(uniqueWord, word.get(uniqueWord) + 1);
        }
        return word;
    }
}
