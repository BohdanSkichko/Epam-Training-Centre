package chapter7.variantb.task1;

import java.util.*;

public class Punctuation extends SentenceElement {
    private final List<String> punctuationList = new ArrayList<>(Arrays.asList(",", ".", ":", ";","?","!","-","\""));

    public List<String> getPunctuationList() {
        return punctuationList;
    }

}
