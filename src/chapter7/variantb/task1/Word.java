package chapter7.variantb.task1;


import java.util.*;

public class Word extends SentenceElement {
    private static final Set<Character> CHARACTER_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'y', 'u'));
    private final String word;

    public String getWord() {
        return word;
    }

    public Word(String word) {
        this.word = word;
    }

    public boolean isFirstVowelLetter() {
        List<Character> chars = new ArrayList<>();
        char[] charsWord = word.toCharArray();
        for (char c : charsWord) {
            chars.add(c);
        }
        return CHARACTER_SET.contains(chars.get(0));
    }

    public char getFirstConsonantLetter() {
        char consonant = 0;
        for (char character : word.toCharArray()) {
            if (!CHARACTER_SET.contains(Character.toLowerCase(character))) {
                consonant = character;
                break;
            }
        }
        return consonant;

    }
    
    public Double getPercentageVowels() {
        double length = word.length();
        double percentage;
        int vowel = 0;
        for (char character : word.toCharArray()) {
            if (CHARACTER_SET.contains(Character.toLowerCase(character))) {
                vowel++;
            }
        }
        if (vowel == 0) {
            percentage = 0;
        } else percentage = vowel / length;

        return percentage;
    }

    public boolean isWord() {
        for (char character : word.toCharArray()) {
            if (Character.isLetter(character)) {
                return true;
            }

        }
        return false;
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
