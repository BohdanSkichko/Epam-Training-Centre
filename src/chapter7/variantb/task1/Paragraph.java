package chapter7.variantb.task1;

import java.util.*;

public class Paragraph {
    private final String paragraph;
    private static final String SENTENCE_SPLIT = "(?<=(?<![A-Z])\\. )";
    private final List<Sentence> sentenceList = new ArrayList<>();



    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        parseParagraph();
    }

    private void parseParagraph() {
        String[] sentences = paragraph.split(SENTENCE_SPLIT);
        for (String sentence : sentences) {
            sentenceList.add(new Sentence(sentence));
        }

    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence sentence : sentenceList) {
            stringBuilder.append(sentence).append(" ");
        }
        return stringBuilder.toString();

    }
    public String getParagraph() {
        return paragraph;
    }
    public List<Sentence> getSentenceList() {
        return sentenceList;
    }


}

