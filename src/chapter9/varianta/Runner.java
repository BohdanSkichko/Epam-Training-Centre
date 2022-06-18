package chapter9.varianta;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
//        TextRedactor.deleteSubstring("put");
//        TextRedactor.replaceSubstring("output", "Input");
//        TextRedactor textRedactor = new TextRedactor();
//        System.out.println(textRedactor.getWordsWithFirstVowelLetter());
//        textRedactor.printWordsLastLetterEqualsFirstLetterNext();
        SubstringDeleter substringDeleter = new SubstringDeleter();
        substringDeleter.delete("error");


    }
}
