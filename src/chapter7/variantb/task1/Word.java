package chapter7.variantb.task1;


import java.util.Objects;

public class Word extends Punctuation {
    private final String word;

    public String getWord() {
        return word;
    }

    public Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) || word != null && word.equals(word1.getWord());
    }


    @Override
    public int hashCode() {
        return getWord() != null ? getWord().hashCode() : 0;
    }

    @Override
    public String toString() {
        return
                word;
    }
}
