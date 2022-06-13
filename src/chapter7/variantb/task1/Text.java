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


    public int getSentenceWithRepeatedWords() {
        int count = 0;
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.containsRepeatedWord()) {
                    count++;
                }
            }
        }
        return count;

    }

    public void printSortedWords() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                wordList.addAll(sentence.getOnlyWords());
            }
        }
        wordList.sort(Comparator.comparing(word -> word.getWord().toLowerCase()));
        String letter = wordList.get(0).getWord().substring(0, 1);
        boolean redline = true;
        for (Word word : wordList) {
            if (!word.getWord().substring(0, 1).equalsIgnoreCase(letter)) {
                redline = true;
                letter = word.getWord().substring(0, 1);
            }
            if (redline) {
                System.out.print("\n\t" + word + " ");
            } else {
                System.out.print(word + " ");
            }
            redline = false;
        }
    }
    public List<Word> getSortedPercentageVowelsLetters() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                wordList.addAll(sentence.getOnlyWords());
            }
        }
        wordList.sort(Comparator.comparing(Word::percentageVowels));
        return wordList;
    }

    public Set<Word> getUniqueWordsInterrogateSentences(int lengthWord) {
        Set<Word> wordList = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.interrogativeSentence()) {
                    for (Word word : sentence.getOnlyWords()) {
                        if (word.toString().length() == lengthWord) {
                            wordList.add(word);
                        }
                    }
                }
            }
        }
        return wordList;
    }

    public List<Sentence> removeConsonantStartingWords(int lengthWord) {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                sentences.add(sentence.removeWordFirstVowelLetter(lengthWord));
            }
        }
        return sentences;
    }

    public List<Sentence> swapFirstAndLastWordSentence() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                sentences.add(sentence.swapFirstAndLastWord());
            }
        }
        return sentences;
    }

    public List<Sentence> sortSentenceQuantityWords() {
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
            referenceWord.add(String.valueOf(paragraphList.get(0).getSentenceList().get(0).getSentenceElements().get(i)));
        }
        Set<String> wordSet = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence == paragraphList.get(0).getSentenceList().get(0)) continue;
                for (Word word : sentence.getSentenceElements()) {
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

