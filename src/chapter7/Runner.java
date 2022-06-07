package chapter7;

import chapter7.varianta.task11.SearcherVowelAndConsonant;
import chapter7.varianta.task7.OnlyLettersTrimmer;
import chapter7.varianta.task8.TextTrimmer;
import chapter7.varianta.task9.WordQuantity;


public class Runner {
    static String string = "During compilation. The compiler analyses and verifies. The code for numerous things";
    public static void main(String[] args) {
        OnlyLettersTrimmer onlyLettersPrinter = new OnlyLettersTrimmer();
        System.out.println(onlyLettersPrinter.deleteNonLetters(args));


        TextTrimmer textPrinter = new TextTrimmer();
        System.out.println(textPrinter.deleteTextBetweenCharset(args));

        WordQuantity quantity = new WordQuantity();
        quantity.findQuantityWords(args).keySet();
        for (String word : quantity.findQuantityWords(args).keySet()) {
            System.out.println(word + ": " + quantity.findQuantityWords(args).get(word));

        }
        SearcherVowelAndConsonant searcherVowelAndConsonant = new SearcherVowelAndConsonant(string);
        System.out.println(searcherVowelAndConsonant.getCountConsonantAndVowel());

    }
}


