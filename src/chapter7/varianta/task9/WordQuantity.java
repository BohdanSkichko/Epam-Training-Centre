package chapter7.varianta.task9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Определить, сколько раз повторяется в тексте каждое слово, которое встре-
//чается в нем.
public class WordQuantity {
    private static final String REMOVE_PUNCTUATION = "[^a-zA-Z]+";
    private static final String REPLACEMENT_FOR_PUNCTUATION = " ";
    private static final String WORD_SPLIT = "\\s";

    public Map<String, Integer> findQuantityWords(String[] input) {

        String[] text = Arrays.toString(input).
                replaceAll(REMOVE_PUNCTUATION, REPLACEMENT_FOR_PUNCTUATION).
                split(WORD_SPLIT);

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : text) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else
                wordMap.put(word, wordMap.get(word) + 1);
        }
        return wordMap;


    }
}
