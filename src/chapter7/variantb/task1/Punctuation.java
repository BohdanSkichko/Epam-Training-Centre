package chapter7.variantb.task1;

import java.util.*;

public  class Punctuation extends SentenceElement {
    public static final List<String> punctuationList = new ArrayList<>(Arrays.asList(",", ".", ":", ";", "?", "!", "-", "\""));

    protected Punctuation(String punctuation) {
        super(punctuation);
    }

   public static List<String> getPunctuationList() {
        return punctuationList;
    }

}
