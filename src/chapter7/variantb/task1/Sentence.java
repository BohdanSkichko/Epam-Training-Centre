package chapter7.variantb.task1;

import java.util.*;

public class Sentence {
    private final String sentence;
    private final List<Word> wordSet = new ArrayList<>();
    private static final String WORD_SPLIT = "([^a-zA-Z']+)";

    public void parseWord() {
        String[] words = sentence.split(WORD_SPLIT);
        for (String word : words) {
            wordSet.add(new Word(word));
        }
    }

    public String findMaxRepeatWord (){
        String word = "all words repeat only one time";
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < wordSet.size(); i++) {
            for (int j = i + 1; j < wordSet.size(); j++) {
                if (wordSet.get(i).equals(wordSet.get(j))) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                word = String.valueOf(wordSet.get(i));
            }
        }
        return word;
    }


    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public List<Word> getWord() {
        return wordSet;
    }

    @Override
    public String toString() {
        parseWord();
        StringBuilder stringBuilder = new StringBuilder();
        for (Word word : wordSet){
            stringBuilder.append(word).append(" ");
        }
        return stringBuilder.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence sentence1)) return false;

        if (getSentence() != null ? !getSentence().equals(sentence1.getSentence()) : sentence1.getSentence() != null)
            return false;
        return wordSet.equals(sentence1.wordSet);
    }

    @Override
    public int hashCode() {
        int result = getSentence() != null ? getSentence().hashCode() : 0;
        result = 31 * result + wordSet.hashCode();
        return result;
    }
}
