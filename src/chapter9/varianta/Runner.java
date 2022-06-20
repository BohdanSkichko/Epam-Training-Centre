package chapter9.varianta;

import chapter9.varianta.TextRedactor.SubstringDeleter;
import chapter9.varianta.TextRedactor.SubstringReplacement;
import chapter9.varianta.TextRedactor.Words;
import chapter9.varianta.TextRedactor.WordsWithFirstVowelLetter;

public class Runner {
    public static void main(String[] args) {

        SubstringDeleter substringDeleter = new SubstringDeleter();
        substringDeleter.delete("the");
        SubstringReplacement substringReplacement = new SubstringReplacement();
        substringReplacement.replace("the", "rooor");
        WordsWithFirstVowelLetter words = new WordsWithFirstVowelLetter();
        System.out.println(words.getWords());
        Words words1 = new Words();
        words1.wordsPrinter();


    }
}
