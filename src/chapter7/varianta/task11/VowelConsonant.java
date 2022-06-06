package chapter7.varianta.task11;

import chapter7.variantb.task1.Sentence;

import java.util.*;

//Найти, каких букв, гласных или согласных, больше в каждом предложении
//текста.
public class VowelConsonant {

    private final List<String> sentenceList = new ArrayList<>();

    public String[] Sentence(String string) {
        return string.split("(?<=[a-z])\\.\\s+");
    }

    public void addSentence(String[] s) {
        sentenceList.addAll(Arrays.asList(s));
    }

    public void count() {
        Set<Character> charactersVowels = new HashSet<>();
        for (char ch : "aeiou".toCharArray()) {
            charactersVowels.add(ch);
        }
        int consonantCount = 0;
        int vowelCount = 0;
        for (String s : sentenceList) {
            for (char c : s.toCharArray())
                if (Character.isLetter(c)) {
                    if (charactersVowels.contains(Character.toLowerCase(c))) {
                        vowelCount++;
                    } else consonantCount++;
                }
        }
        if (consonantCount > vowelCount) {
            System.out.println(consonantCount + "const");
        } else if (vowelCount > consonantCount) System.out.println(vowelCount + "volue");
        else System.out.println("vowel == consonant : " + vowelCount);
    }


    public static void main(String[] args) {
        String s = "ssaa. Aaasas. wefavsv Daafsa. ASdaadsa, aw as a.";
        VowelConsonant vowelConsonant = new VowelConsonant();
        vowelConsonant.addSentence(vowelConsonant.Sentence(s));
        System.out.println(vowelConsonant.sentenceList.size());
        vowelConsonant.count();
    }
}
