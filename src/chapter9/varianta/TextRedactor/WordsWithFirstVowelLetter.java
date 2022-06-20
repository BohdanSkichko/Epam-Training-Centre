package chapter9.varianta.TextRedactor;

import chapter7.variantb.task1.Sentence;
import chapter7.variantb.task1.SentenceElement;
import chapter7.variantb.task1.Word;
import chapter9.varianta.helper.HolderProperties;
import chapter9.varianta.helper.ReadAndWriteProperties;

import java.util.ArrayList;
import java.util.List;

public class WordsWithFirstVowelLetter {
    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        ReadAndWriteProperties readAndWriteProperties = new ReadAndWriteProperties();
        String content = readAndWriteProperties.read(HolderProperties.FILE_INPUT.getPath());
        for (SentenceElement word : new Sentence(content).getSentenceElements()) {
            if (word instanceof Word && ((Word) word).isFirstVowelLetter()) {
                words.add(String.valueOf(word));
            }

        }
        return words;
    }
}
