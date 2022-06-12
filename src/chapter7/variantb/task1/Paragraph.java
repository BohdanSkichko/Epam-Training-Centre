package chapter7.variantb.task1;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Locale.ENGLISH;
import static java.util.Locale.US;

public class Paragraph {
    private final List<Sentence> sentenceList = new ArrayList<>();


    public Paragraph(String paragraph) {
        parseParagraph(paragraph);
    }

    public void parseParagraph(String input) {
        Locale currentLocale = new Locale(ENGLISH.getLanguage(), US.getLanguage());
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(currentLocale);
        sentenceIterator.setText(input);
        int boundary = sentenceIterator.first();
        int lastBoundary = 0;
        while (boundary != BreakIterator.DONE) {
            boundary = sentenceIterator.next();
            if (boundary != BreakIterator.DONE) {
                sentenceList.add(new Sentence(input.substring(lastBoundary, boundary)));
            }
            lastBoundary = boundary;
        }
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence sentence : sentenceList) {
            stringBuilder.append(sentence);
        }
        return stringBuilder.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragraph)) return false;

        Paragraph paragraph = (Paragraph) o;

        return getSentenceList() != null ? getSentenceList().equals(paragraph.getSentenceList()) : paragraph.getSentenceList() == null;
    }

    @Override
    public int hashCode() {
        return getSentenceList() != null ? getSentenceList().hashCode() : 0;
    }
}

