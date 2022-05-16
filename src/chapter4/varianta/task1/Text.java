package chapter4.varianta.task1;

import java.util.ArrayList;
import java.util.List;


public class Text {
    private String title;
    private String text;
    private final List<Sentence> sentenceList = new ArrayList<>();
    private final List<Word> wordList = new ArrayList<>();
    private final List<Text> textList = new ArrayList<>();



    public void printText() {
        System.out.println(sentenceList);
    }

    public void printTitle() {
        
    }

    public void addSentence(Sentence sentence) {
        sentenceList.add(sentence);

    }

    public void addWord(Word someWord) {
        if (someWord.getWord() != null) {
            wordList.add(someWord);
        }
    }


    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }
}

