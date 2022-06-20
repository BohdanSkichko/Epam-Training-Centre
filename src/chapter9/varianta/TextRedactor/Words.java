package chapter9.varianta.TextRedactor;

import chapter7.variantb.task1.Sentence;
import chapter7.variantb.task1.SentenceElement;
import chapter7.variantb.task1.Word;
import chapter9.varianta.helper.HolderProperties;
import chapter9.varianta.helper.ReadAndWriteProperties;

import java.util.ArrayList;
import java.util.List;

public class Words {
    public void wordsPrinter() {
        List<String> words = new ArrayList<>();
        ReadAndWriteProperties readAndWriteProperties = new ReadAndWriteProperties();
        String content = readAndWriteProperties.read(HolderProperties.FILE_INPUT.getPath());
        for (SentenceElement word : new Sentence(content).getSentenceElements()) {
            if (word instanceof Word) {
                words.add(String.valueOf(word));
            }
        }
        for (int i = 0; i < words.size() - 1; i++) {
            int first = 0;
            int last = words.get(i).length() - 1;
            if (words.get(i).charAt(last) == (words.get(i + 1).charAt(first))) {
                System.out.println("first word: " + words.get(i) + " second word: " + words.get(i + 1));

            }
        }
    }
}