package chapter4.varianta.task1;

import java.util.Locale;
import java.util.Objects;

public class Word {
    private final String word;


    Word(String word) {
        this.word = word;
    }



    @Override
    public String toString() {
        return word.trim();
    }

    public String getWord() {
        return word;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(getWord(), word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }
}
