package chapter7.variantb.task1;

import java.util.*;
import java.util.stream.Collectors;


public class Text {
    private final String text;
    private static final String PARAGRAPH_SPLIT = "(\n)";
    private final List<Paragraph> paragraphList = new ArrayList<>();

    public Text(String text) {
        this.text = text;
    }

    public void parseText() {
        String[] paragraphs = text.split(PARAGRAPH_SPLIT);
        for (String paragraph : paragraphs) {
            paragraphList.add(new Paragraph(paragraph));
        }
        for (Paragraph paragraph : paragraphList) {
            paragraph.parseSentence();
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


    public String getText() {
        return text;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Paragraph p : paragraphList) {
            stringBuilder.append(p);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text text1)) return false;

        if (!Objects.equals(text, text1.text)) return false;
        return paragraphList.equals(text1.paragraphList);
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + paragraphList.hashCode();
        return result;
    }

}

