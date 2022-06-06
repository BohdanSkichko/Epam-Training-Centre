package chapter7.varianta.task9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Определить, сколько раз повторяется в тексте каждое слово, которое встре-
//чается в нем.
public class QuantityWordPrinter {
    public void findQuantityWords(String[] input) {

        String[] text = Arrays.toString(input).
                replaceAll("[-.?!)(,:{}<>\\[\\]]", "").
                split("\s");

        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : text) {
            if (!wordMap.containsKey(w)) {
                wordMap.put(w,0);
            }
            wordMap.put(w, wordMap.get(w)+1);
        }
        for (String word : wordMap.keySet()) {
            System.out.println(word + ": " + wordMap.get(word));
        }
    }
}
