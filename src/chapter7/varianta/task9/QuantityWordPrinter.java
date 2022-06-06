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
            if (!w.isEmpty()) {
                Integer count = wordMap.get(w);
                if (count == null) {
                    count = 0;
                }
                wordMap.put(w, ++count);
            }
        }
        for (String word : wordMap.keySet()) {
            System.out.println(word + ": " + wordMap.get(word));
        }
    }
}
