package chapter7.variantb.task1;

import java.util.*;
import java.util.stream.Collectors;


public class Sentence {
    private final List<Word> sentenceElements = new ArrayList<>();
    private final List<Word> onlyWords = new ArrayList<>();

    private void addOnlyWord() {
        for (Word wordList : sentenceElements) {
            if (wordList.isWord()) {
                onlyWords.add(wordList);
            }
        }
    }

    public Sentence(String sentence) {
        parseSentence(sentence);
        addOnlyWord();
    }

    private void parseSentence(String input) {
        String delimiter = new Punctuation().getPunctuationList().toString();
        StringTokenizer st = new StringTokenizer(input, delimiter, true);
        while (st.hasMoreElements()) {
            sentenceElements.add(new Word(st.nextToken()));
        }

    }

    public Sentence removeWordFirstVowelLetter(int length){
        sentenceElements.removeIf(word -> word.isFirstVowelLetter() && word.toString().length() == length);
        return new Sentence(sentenceElements.stream().map(Word::toString).collect(Collectors.joining("")));
    }


    public boolean interrogativeSentence() {
        for (Word word : sentenceElements) {
            if (word.toString().equals("?")) {
                return true;
            }
        }
        return false;
    }

    public Sentence swapFirstAndLastWord() {
        Word first = sentenceElements.get(0);
        sentenceElements.remove(0);
        Word second = null;
        for (int j = sentenceElements.size() - 1; j >= 0; j--) {
            if (sentenceElements.get(j).isWord()) {
                second = sentenceElements.get(j);
                sentenceElements.remove(j);
                sentenceElements.add(j, first);
                break;
            }
        }
        sentenceElements.add(0, second);
        return new Sentence(sentenceElements.stream().map(Word::toString).collect(Collectors.joining("")));
    }


    public String findMaxRepeatedWord() {
        String word = "all words repeat only one time";
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < onlyWords.size(); i++) {
            for (int j = i + 1; j < onlyWords.size(); j++) {
                if (onlyWords.get(i).getWord().equalsIgnoreCase(onlyWords.get(j).getWord())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                word = String.valueOf(onlyWords.get(i));
            }
        }
        return word;
    }

    public boolean containsRepeatedWord() {
        for (int i = 0; i < onlyWords.size(); i++) {
            for (int j = i + 1; j < onlyWords.size(); j++) {
                if (onlyWords.get(i).getWord().equalsIgnoreCase(onlyWords.get(j).getWord()))
                    return true;
            }
        }
        return false;
    }

    public List<Word> getSentenceElements() {
        return sentenceElements;
    }


    public List<Word> getOnlyWords() {
        return onlyWords;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        if (getSentenceElements() != null ? !getSentenceElements().equals(sentence.getSentenceElements()) : sentence.getSentenceElements() != null)
            return false;
        return getOnlyWords() != null ? getOnlyWords().equals(sentence.getOnlyWords()) : sentence.getOnlyWords() == null;
    }

    @Override
    public int hashCode() {
        int result = getSentenceElements() != null ? getSentenceElements().hashCode() : 0;
        result = 31 * result + (getOnlyWords() != null ? getOnlyWords().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Word word : sentenceElements) {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();

    }
}
