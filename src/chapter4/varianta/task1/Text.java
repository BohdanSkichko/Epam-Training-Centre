package chapter4.varianta.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Text implements Itext {
    private String header;
    private final List<Sentence> sentenceList = new ArrayList<>();

    @Override
    public void printText() {
        StringBuilder stringBuilder = new StringBuilder(sentenceList.toString());
        for (int i = 0; i < sentenceList.size() - 1; i++) {
            if (stringBuilder.toString().replace(" ",))
            stringBuilder.setCharAt(1, Character.toUpperCase(stringBuilder.toString().charAt(1)));
            stringBuilder.setCharAt(stringBuilder.indexOf(","), '.');
        }
        stringBuilder.append('.');
        String s = stringBuilder.toString();
        s = s.replace("[", "");
        s = s.replace("]", "");
        System.out.println(s);
    }


    @Override
    public String toString() {
        return header;
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

