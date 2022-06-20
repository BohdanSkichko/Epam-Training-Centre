package chapter9.varianta;

import chapter9.varianta.textreditor.SubstringDeleter;
import chapter9.varianta.textreditor.SubstringReplacer;
import chapter9.varianta.textreditor.Words;
import chapter9.varianta.textreditor.WordsWithFirstVowelLetterSeeker;

public class Runner {
    public static void main(String[] args) {

        SubstringDeleter substringDeleter = new SubstringDeleter();
        substringDeleter.delete("the");
        SubstringReplacer substringReplacement = new SubstringReplacer();
        substringReplacement.replace("the", "rooor");
        WordsWithFirstVowelLetterSeeker words = new WordsWithFirstVowelLetterSeeker();
        words.getWords();
        Words words1 = new Words();
        words1.print();


    }
}
