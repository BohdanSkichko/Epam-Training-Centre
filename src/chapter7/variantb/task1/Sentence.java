package chapter7.variantb.task1;

import java.util.*;

public class Sentence {
    private final String sentence;
    private final List<Word> wordList = new ArrayList<>();
    private static final String WORD_SPLIT = "([^a-zA-Z']+)";

    public Sentence(String sentence) {
        this.sentence = sentence;
        parseSentence();
    }

    public void parseSentence() {
        String[] words = sentence.split(WORD_SPLIT);
        for (String word : words) {
            wordList.add(new Word(word));
        }
    }

    public boolean isUnique(String word) {
        for (Word value : wordList) {
            if (value.getWord().equalsIgnoreCase(word)) {
                return false;
            }
        }
        return true;
    }

    public String findMaxRepeatedWord() {
        String word = "all words repeat only one time";
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (wordList.get(i).getWord().equalsIgnoreCase(wordList.get(j).getWord())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                word = String.valueOf(wordList.get(i));
            }
        }
        return word;
    }

    public boolean isSentenceHasRepeatedWord() {
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (wordList.get(i).getWord().equalsIgnoreCase(wordList.get(j).getWord()))
                    return true;
            }
        }
        return false;
    }


    public int quantityWords() {
        return wordList.size();
    }

    public List<Word> getWordList() {
        return wordList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = wordList.size() - 1;
        for (int i = 0; i < wordList.size(); i++) {
            if (i < count) {
                stringBuilder.append(wordList.get(i)).append(" ");
            } else stringBuilder.append(wordList.get(i)).append(".");
        }
        return stringBuilder.toString();

    }
}
