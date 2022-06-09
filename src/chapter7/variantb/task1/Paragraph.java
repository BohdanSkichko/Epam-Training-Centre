package chapter7.variantb.task1;

import java.util.*;

public class Paragraph {
    private final String paragraph;
    private static final String SENTENCE_SPLIT = "(?<=(?<![A-Z])\\. )";
    private final List<Sentence> sentenceList = new ArrayList<>();



    public void parseSentence() {
        String[] sentences = paragraph.split(SENTENCE_SPLIT);
        for (String sentence : sentences) {
            sentenceList.add(new Sentence(sentence));
        }
        for (Sentence sentence : sentenceList){
            sentence.parseWord();
        }
    }


    public String getParagraph() {
        return paragraph;
    }

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }


    @Override
    public String toString() {
        return  paragraph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragraph paragraph1)) return false;

        if (getParagraph() != null ? !getParagraph().equals(paragraph1.getParagraph()) :
                paragraph1.getParagraph() != null) return false;
        return getSentenceList() != null ? getSentenceList().equals(paragraph1.getSentenceList()) :
                paragraph1.getSentenceList() == null;
    }

    @Override
    public int hashCode() {
        int result = getParagraph() != null ? getParagraph().hashCode() : 0;
        result = 31 * result + (getSentenceList() != null ? getSentenceList().hashCode() : 0);
        return result;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }


}

