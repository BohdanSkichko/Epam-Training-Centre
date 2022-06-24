package chapter9.varianta.textreditor;

import chapter7.variantb.task1.Sentence;
import chapter7.variantb.task1.SentenceElement;
import chapter7.variantb.task1.Word;
import helper.io.IOHelper;
import helper.properties.PropertiesEnum;
import java.util.ArrayList;
import java.util.List;



public class WordsWithFirstVowelLetterSeeker {
    public void getWords () {
        List<String> words = new ArrayList<>();
        IOHelper ioHelper = new IOHelper();
        String content = ioHelper.readFromFile(PropertiesEnum.INPUT_FILE.getPath());
        for (SentenceElement word : new Sentence(content).getSentenceElements()) {
            if (word instanceof Word && ((Word) word).isFirstVowelLetter()) {
                words.add(String.valueOf(word));
            }
        }
        ioHelper.appendWriteToFile(PropertiesEnum.OUTPUT_FILE.getPath(),
                "\n" + words);
    }
}
