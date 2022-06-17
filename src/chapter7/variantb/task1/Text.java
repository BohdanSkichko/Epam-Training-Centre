package chapter7.variantb.task1;

import java.util.*;

public class Text {

    private static final String PARAGRAPH_SPLIT = "(\n)";
    private final List<Paragraph> paragraphList = new ArrayList<>();

    public Text(String text) {
        parseText(text);
    }

    public void parseText(String input) {
        String[] paragraphs = input.split(PARAGRAPH_SPLIT);
        for (String paragraph : paragraphs) {
            paragraphList.add(new Paragraph(paragraph));
        }
    }

    public List<String> getRepeatedWord() {
        List<String> repeatedWord = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                repeatedWord.add(sentence.findMaxRepeatedWord());
            }
        }
        return repeatedWord;
    }


    public int getCountSentenceWithRepeatedWords() {
        int count = 0;
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.isContainsRepeatedWord()) {
                    count++;
                }
            }
        }
        return count;

    }

    public void printSortedFirstLetterWord() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement sentenceElement : sentence.getSentenceElements())
                    if (sentenceElement.isWord())
                        wordList.add((Word) sentenceElement);
            }
        }
        wordList.sort(Comparator.comparing(word -> word.getContent().toLowerCase()));
        String letter = wordList.get(0).getContent().substring(0, 1);
        boolean redline = true;
        for (SentenceElement word : wordList) {
            if (!word.getContent().substring(0, 1).equalsIgnoreCase(letter)) {
                redline = true;
                letter = word.getContent().substring(0, 1);
            }
            if (redline) {
                System.out.print("\n\t" + word + " ");
            } else {
                System.out.print(word + " ");
            }
            redline = false;
        }
        System.out.println();
    }

    public List<Word> getSortedPercentageVowelsLetters() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement sentenceElement : sentence.getSentenceElements()) {
                    if (sentenceElement.isWord()) {
                        wordList.add((Word) sentenceElement);
                    }
                }
            }
        }
        wordList.sort(Comparator.comparing(Word::getPercentageVowels));
        return wordList;
    }


    public List<Word> getSortedSecondConsonantLetter() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement word : sentence.getSentenceElements()) {
                    if (word.isWord() && ((Word) word).isFirstVowelLetter()) {
                        wordList.add((Word) word);
                    }
                }
            }
        }
        wordList.sort(Comparator.comparing(Word::getFirstConsonantLetter));
        return wordList;
    }

    public Set<SentenceElement> getUniqueWordsInterrogateSentences(int lengthWord) {
        Set<SentenceElement> words = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.isInterrogativeSentence()) {
                    for (SentenceElement word : sentence.getSentenceElements()) {
                        if (word.isWord() && word.getContent().length() == lengthWord) {
                            words.add(word);
                        }
                    }
                }
            }
        }
        return words;

    }

    public void removeVowelStartingWords(int lengthWord) {
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                sentence.removeWordFirstVowelLetter(lengthWord);
            }
        }
    }

    public void swapFirstAndLastSentenceWords() {
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                sentence.swapFirstAndLastWord();
            }
        }
    }


    public List<Sentence> getSortedQuantityWordsSentences() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            sentences.addAll(paragraph.getSentenceList());
        }
        sentences.sort(Comparator.comparing(sentence -> sentence.getSentenceElements().size()));
        return sentences;

    }


    public String getUniqueWord() {
        List<String> referenceWord = new ArrayList<>();
        for (int i = 0; i < getParagraphList().get(0).getSentenceList().get(0).getSentenceElements().size(); i++) {
            if (paragraphList.get(0).getSentenceList().get(0).getSentenceElements().get(i).isWord())
                referenceWord.add(String.valueOf(paragraphList.get(0).getSentenceList().get(0).getSentenceElements().get(i)));
        }
        Set<String> wordSet = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence == paragraphList.get(0).getSentenceList().get(0)) continue;
                for (SentenceElement word : sentence.getSentenceElements()) {
                    wordSet.add(String.valueOf(word).toLowerCase());
                }
            }
        }
        for (String word : referenceWord) {
            if (!wordSet.contains(word.toLowerCase())) {
                return word;
            }
        }
        return null;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = paragraphList.size() - 1;
        for (int i = 0; i < paragraphList.size(); i++) {
            if (i < count) {
                stringBuilder.append(paragraphList.get(i)).append("\n");
            } else stringBuilder.append(paragraphList.get(i));
        }
        return stringBuilder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return getParagraphList() != null ? getParagraphList().equals(text.getParagraphList()) : text.getParagraphList() == null;
    }

    @Override
    public int hashCode() {
        return getParagraphList() != null ? getParagraphList().hashCode() : 0;
    }
}

