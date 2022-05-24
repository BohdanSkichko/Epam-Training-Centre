package chapter4.varianta.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sentence {

    private final List<Word> wordList = new ArrayList<>();


    public void addWord(Word someWord) {
        if (wordList.isEmpty()) {
            wordList.add(someWord.UppercaseFirstLetters());
        } else {
            wordList.add(someWord);
        }
    }


    public List<Word> getWordList() {
        return wordList;
    }


    @Override
    public String toString() {
        return wordList.stream()
                .map(Word::toString)
                .collect(Collectors.joining(" ","","."));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence sentence)) return false;
        return Objects.equals(getWordList(), sentence.getWordList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWordList());
    }
}