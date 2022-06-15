package chapter7.variantb.task1;

import java.util.*;
import java.util.stream.Collectors;


public class Sentence {
    private final List<SentenceElement> sentenceElements = new ArrayList<>();


    public Sentence(String sentence) {
        parseSentence(sentence);
    }

    private void parseSentence(String input) {
        String delimiter = Punctuation.getPunctuationList().toString();
        StringTokenizer st = new StringTokenizer(input, delimiter, true);
        while (st.hasMoreElements()) {
            String nextToken = st.nextToken();
            if (Character.isLetter(nextToken.charAt(0))) {
                sentenceElements.add(new Word(nextToken));
            } else sentenceElements.add(new Punctuation(nextToken));
        }

    }


    public void removeWordFirstVowelLetter(int length) {
        sentenceElements.removeIf(word -> ((Word) word).isFirstVowelLetter() &&  word.toString().length() == length);
    }


    public boolean isInterrogativeSentence() {
        for (SentenceElement sentenceElement : sentenceElements) {
            if (sentenceElement.toString().equals("?")) {
                return true;
            }
        }
        return false;
    }

    public Sentence swapFirstAndLastWord() {
        Word first = null;
        for (SentenceElement word : sentenceElements) {
            if (word.isWord()) {
                first = (Word) word;
                break;
            }
        }

        sentenceElements.remove(0);
        Word second = null;
        for (int j = sentenceElements.size() - 1; j >= 0; j--) {
            if (sentenceElements.get(j).isWord()) {
                second = (Word) sentenceElements.get(j);
                sentenceElements.remove(j);
                sentenceElements.add(j, first);
                break;
            }
        }
        sentenceElements.add(0, second);
        return this;
    }


    public String findMaxRepeatedWord() {
        String word = "all words repeat only one time";
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < sentenceElements.size(); i++) {
            if (!sentenceElements.get(i).isWord()) continue;
            for (int j = i + 1; j < sentenceElements.size(); j++) {
                if (sentenceElements.get(i).getContent().equalsIgnoreCase(sentenceElements.get(j).getContent())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                word = String.valueOf(sentenceElements.get(i));
            }
        }
        return word;
    }

    public boolean isContainsRepeatedWord() {
        for (int i = 0; i < sentenceElements.size(); i++) {
            if (!sentenceElements.get(i).isWord()) continue;
            for (int j = i + 1; j < sentenceElements.size(); j++) {
                if (sentenceElements.get(i).getContent().equalsIgnoreCase(sentenceElements.get(j).getContent()))
                    return true;
            }
        }
        return false;
    }

    public List<SentenceElement> getSentenceElements() {
        return sentenceElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        return getSentenceElements().equals(sentence.getSentenceElements());
    }

    @Override
    public int hashCode() {
        return getSentenceElements().hashCode();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SentenceElement sentenceElement : getSentenceElements()) {
            stringBuilder.append(sentenceElement);
        }
        return stringBuilder.toString();

    }
}
