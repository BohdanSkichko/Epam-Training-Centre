package chapter7.variantb.task1;

import java.util.*;


public class Text {
    private static final String PARAGRAPH_SPLIT = "(\n)";
    private final List<Paragraph> paragraphList = new ArrayList<>();

    public Text() {
    }

    public void parseText(String input) {
        String[] paragraphs = input.split(PARAGRAPH_SPLIT);
        for (String paragraph : paragraphs) {
            paragraphList.add(new Paragraph(paragraph));
        }
    }

    public List<String> findRepeatedWord() {
        List<String> repeatedWord = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                repeatedWord.add(sentence.findMaxRepeatedWord());
            }
        }
        return repeatedWord;
    }


    public int findCountSentenceWithRepeatedWords() {
        int count = 0;
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.isSentenceHasRepeatedWord()) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Sentence> increaseSentenceLenght() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            sentences.addAll(paragraph.getSentenceList());
        }
        sentences.sort(Comparator.comparing(Sentence::quantityWords));
        return sentences;

    }

    public String UniqueWord() {
        List<String> wordList = new ArrayList<>();
        int count = paragraphList.get(0).getSentenceList().get(0).getWordList().size();
        for (int i = 0; i < count; i++) {
            wordList.add(String.valueOf(paragraphList.get(0).getSentenceList().get(0).getWordList().get(i)));
        }
        List<String> wordList2 = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (Word word : sentence.getWordList()) {
                    wordList2.add(String.valueOf(word));
                }
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList2.size(); j++) {
                if (wordList.get(i).equalsIgnoreCase(wordList2.get(j))){
                         
                }

            }
        }
        return word;

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

