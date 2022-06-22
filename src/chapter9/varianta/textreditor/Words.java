package chapter9.varianta.textreditor;

import chapter7.variantb.task1.Sentence;
import chapter7.variantb.task1.SentenceElement;
import chapter7.variantb.task1.Word;
import helper.helper.IOHelper;
import helper.helper.PropertiesEnum;


import java.util.ArrayList;
import java.util.List;

public class Words {
    public void print() {
        List<String> words = new ArrayList<>();
        IOHelper ioHelper = new IOHelper();
        String content = ioHelper.readFromFile(PropertiesEnum.INPUT_FILE.getPath());
        for (SentenceElement word : new Sentence(content).getSentenceElements()) {
            if (word instanceof Word) {
                words.add(String.valueOf(word));
            }
        }
        for (int i = 0; i < words.size() - 1; i++) {
            int first = 0;
            int last = words.get(i).length() - 1;
            if (words.get(i).charAt(last) == (words.get(i + 1).charAt(first))) {
                ioHelper.appendWriteToFile(PropertiesEnum.OUTPUT_FILE.getPath(),
                        "\n" + "first word: " + words.get(i) + " second word: " + words.get(i + 1));
            }
        }
    }
}