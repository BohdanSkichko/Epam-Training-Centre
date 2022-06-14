package chapter4.varianta.task1;

import java.util.Objects;

public class Word {
    private final String word;

    Word(String word) {
        if (word == null) throw new NullPointerException("word can't be null");
        this.word = word.trim();
    }

    public Word UppercaseFirstLetters() {
        StringBuilder firstWord = new StringBuilder(word);
        int i = 0;
        do {
            firstWord.replace(i, i + 1, firstWord.substring(i,i + 1).toUpperCase());
            i =  firstWord.indexOf(" ", i) + 1;
        } while (i > 0 && i < firstWord.length());

        return new Word(firstWord.toString());
    }


    @Override
    public String toString() {
        return word;
    }

    public String getWord() {
        return word;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word word1)) return false;
        return Objects.equals(getWord(), word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }
}
