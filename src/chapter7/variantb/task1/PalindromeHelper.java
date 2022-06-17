package chapter7.variantb.task1;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    static void printPalindrome(Text text) {
        List<String> words = new ArrayList<>();
        for (Paragraph paragraph : text.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement sentenceElement : sentence.getSentenceElements()) {
                    if (sentenceElement.isWord()) {
                        words.add(sentenceElement.toString().toLowerCase());
                    }
                }
            }
        }
        String str = String.join("", words);
        int n = str.length();
        if (n < 2)
            return;
        int maxLength = 1, start = 0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i))
                high++;

            while (low >= 0 && str.charAt(low) == str.charAt(i))
                low--;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }
        System.out.println(str.substring(start, start + maxLength));

    }

}
