package chapter4.varianta.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {
    String sentence;
    private final List<Word> wordList = new ArrayList<>();
    public void addWord(Word w) {
        if (w.getWord() != null)
        wordList.add(w);
    }
//    Sentence(){
//        this.sentence = getWordList();
//    }

    public List<Word> getWordList() {
        return wordList;
    }

    @Override
    public String toString() {
        return  wordList.toString();

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