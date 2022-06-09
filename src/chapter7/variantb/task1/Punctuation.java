package chapter7.variantb.task1;

import java.util.*;

public class Punctuation extends PunctuationI {
    public List<String> getPunctuationList() {
        return punctuationList;
    }
    private final List<String>  punctuationList = new ArrayList<>(Arrays.asList(",",".",":",";"));


}
