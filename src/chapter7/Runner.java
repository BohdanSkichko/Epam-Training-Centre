package chapter7;

import chapter7.varianta.task7.OnlyLettersPrinter;
import chapter7.varianta.task8.TextPrinter;
import chapter7.varianta.task9.QuantityWordPrinter;


public class Runner {
    public static void main(String[] args) {
        OnlyLettersPrinter onlyLettersPrinter = new OnlyLettersPrinter();
        System.out.println(onlyLettersPrinter.deleteNonLetters(args));


        TextPrinter textPrinter = new TextPrinter();
        System.out.println(textPrinter.deleteTextBetweenCharset(args));

        QuantityWordPrinter quantity = new QuantityWordPrinter();
        quantity.findQuantityWords(args);

    }

}
