package chapter7.variantb.task1;


import java.util.*;

public class Word extends SentenceElement {
    private static final Set<Character> CHARACTER_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'y', 'u'));

    public Word(String word) {
        super(word);
    }

    public boolean isFirstVowelLetter() {
        List<Character> chars = new ArrayList<>();
        char[] charsWord = getContent().toCharArray();
        for (char c : charsWord) {
            chars.add(c);
        }
        return CHARACTER_SET.contains(chars.get(0));
    }

    public char getFirstConsonantLetter() {
        char consonant = 0;
        for (char character : getContent().toCharArray()) {
            if (!CHARACTER_SET.contains(Character.toLowerCase(character))) {
                consonant = character;
                break;
            }
        }
        return consonant;

    }

    public Double getPercentageVowels() {
        double length = getContent().length();
        double percentage;
        int vowel = 0;
        for (char character : getContent().toCharArray()) {
            if (CHARACTER_SET.contains(Character.toLowerCase(character))) {
                vowel++;
            }
        }
        if (vowel == 0) {
            percentage = 0;
        } else percentage = vowel / length;

        return percentage;
    }
}
