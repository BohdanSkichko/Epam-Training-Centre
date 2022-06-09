package chapter7.variantb.task1;


import java.util.Objects;

public class Word extends PunctuationI {
    private final String word;

    public String getWord() {
        return word;
    }

    public Word(String word) {
        this.word = word;
    }
//
//
//    public Word UppercaseFirstLetters() {
//        StringBuilder firstWord = new StringBuilder(word);
//        int i = 0;
//        do {
//            firstWord.replace(i, i + 1, firstWord.substring(i, i + 1).toUpperCase());
//            i = firstWord.indexOf(" ", i) + 1;
//        } while (i > 0 && i < firstWord.length());
//
//        return new Word(firstWord.toString());
//    }

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
