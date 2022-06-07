package chapter7.varianta.task11;

import java.util.*;

public class SearcherVowelAndConsonant {

    private static final Set<Character> CHARACTER_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'y', 'u'));
    private static final List<String> sentenceList = new ArrayList<>();

    public SearcherVowelAndConsonant(String text) {
        sentenceList.addAll(Arrays.asList(text.split("(?<=[a-z])\\.\\s+")));
    }

    public Map<String, СountConsonantAndVowel> getCountConsonantAndVowel() {
        Map<String, СountConsonantAndVowel> consonantAndVowelMap = new LinkedHashMap<>();
        for (String sentence : sentenceList) {
            СountConsonantAndVowel consonantAndVowel = new СountConsonantAndVowel();
            consonantAndVowelMap.put(sentence,consonantAndVowel);
            for (char character : sentence.toCharArray()) {
                if (!Character.isLetter(character)) continue;
                if (CHARACTER_SET.contains(Character.toLowerCase(character))) {
                    consonantAndVowel.vowel++;
                } else consonantAndVowel.consonant++;
            }
        }
        return consonantAndVowelMap;
    }

    private static class СountConsonantAndVowel {
        private int consonant;
        private int vowel;

        public СountConsonantAndVowel() {

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
                    " consonant: " + consonant +
                            " vowel: " + vowel;
        }

        public void setVowel(int vowel) {
            this.vowel = vowel;
        }

        public СountConsonantAndVowel(int consonant, int vowel) {
            this.consonant = consonant;
            this.vowel = vowel;
        }
    }
}
