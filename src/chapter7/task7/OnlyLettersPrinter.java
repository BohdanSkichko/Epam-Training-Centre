package chapter7.task7;

import java.util.Arrays;

//Из текста удалить все символы, кроме пробелов, не являющиеся буквами. Между
//последовательностями подряд идущих букв оставить хотя бы один пробел.
public class OnlyLetters {
    public String deleteNotLetter(String[] text) {
        String letter = Arrays.toString(text);
        String s = letter.replaceAll("[^a-zA-Z]+", " ");
        return s.trim();
    }
    public static void main(String[] args) {
        String [] s = {"saafa ava ae w r9 -0qw q  __ {] ] []][ sda ca df xxx"};
        OnlyLetters onlyLetters = new OnlyLetters();
        System.out.println(onlyLetters.deleteNotLetter(s));

    }
}

