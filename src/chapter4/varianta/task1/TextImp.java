package chapter4.varianta.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class TextImp implements Text {
    private String header;
    private final List<Sentence> sentenceList = new ArrayList<>();

    @Override
    public void printText() {
        StringBuilder stringBuilder = new StringBuilder(sentenceList.toString());
        for (int i = 0; i < sentenceList.size() - 1; i++) {
            stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.toString().charAt(0)));
        }
        stringBuilder.append('.');
        System.out.println(stringBuilder);

    }


    @Override
    public String toString() {
        return sentenceList.stream()
                .map(Sentence::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public void printHeader() {
        System.out.println(header);
    }

    @Override
    public void addSentence(Sentence sentence) {
        sentenceList.add(sentence);

    }


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }


}

