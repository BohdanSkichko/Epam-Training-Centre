package chapter7.variantb.task1;

import java.util.*;
import java.util.stream.Collectors;

public class Word {
    private static final String WORD_SPLIT = "([^a-zA-Z]+)";
    private final List<String> wordList = new ArrayList<>();

    void splitWord(Sentence sentence) {
        String[] words = Arrays.toString(sentence.getStringList().toArray()).
                replaceAll("'","").
                split(WORD_SPLIT);
        for (String s : words) {
            if (s.length() >= 2) {
                wordList.add(s);
            }
        }
    }



        public List<String> getWordList () {
            return wordList;
        }


    }
