package chapter7.varianta.task11;

import java.util.*;

//Найти, каких букв, гласных или согласных, больше в каждом предложении
//текста.
public class SearcherVowelAndConsonant {

    private static final Set<Character> CHARACTER_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'y', 'u'));
    private static final List<String> sentenceList = new ArrayList<>();

    public SearcherVowelAndConsonant(String text) {
        sentenceList.addAll(Arrays.asList(text.split("(?<=[a-z])\\.\\s+")));
    }

    public ConsonantAndVowel getCountConsonantAndVowel() {
        ConsonantAndVowel consonantAndVowel = new ConsonantAndVowel();
        for (String sentence : sentenceList) {
            for (char character : sentence.toCharArray()) {
                if (!Character.isLetter(character)) continue;
                if (CHARACTER_SET.contains(Character.toLowerCase(character))) {
                    consonantAndVowel.vowel++;
                } else consonantAndVowel.consonant++;
            }
        }
        return consonantAndVowel;
    }

    private static class ConsonantAndVowel {
        private int consonant;
        private int vowel;

        public ConsonantAndVowel() {

        }

        public int getConsonant() {
            return consonant;
        }

        public void setConsonant(int consonant) {
            this.consonant = consonant;
        }

        public int getVowel() {
            return vowel;
        }

        @Override
        public String toString() {
            return
                    "consonant: " + consonant +
                            "vowel: " + vowel;
        }

        public void setVowel(int vowel) {
            this.vowel = vowel;
        }

        public ConsonantAndVowel(int consonant, int vowel) {
            this.consonant = consonant;
            this.vowel = vowel;
        }
    }


    public static void main(String[] args) {
        String s = "ssaaa. Aaasas. wefavsv Daafsa. ASdaadsa, aw attts a.";
        SearcherVowelAndConsonant vowelConsonant = new SearcherVowelAndConsonant(s);
        System.out.println(vowelConsonant.getCountConsonantAndVowel().getConsonant());
        vowelConsonant.getCountConsonantAndVowel();

    }
}
//        if (consonantCount > vowelCount) {
//            System.out.println(consonantCount + "const");
//        } else if (vowelCount > consonantCount) System.out.println(vowelCount + "volue");
//        else System.out.println("vowel == consonant : " + vowelCount);