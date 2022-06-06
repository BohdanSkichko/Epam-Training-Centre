package chapter7.varianta.task7;

import java.util.Arrays;

//Из текста удалить все символы, кроме пробелов, не являющиеся буквами. Между
//последовательностями подряд идущих букв оставить хотя бы один пробел.
public class OnlyLettersTrimmer{
    public String deleteNonLetters(String[] input) {
        String s = Arrays.toString(input).replaceAll("[^a-zA-Z]+", " ");
        return s.trim();
    }
}

