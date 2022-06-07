package chapter7.variantb.task1;

import java.util.*;

public class Paragraph {
    private static final String PARAGRAPH_SPLIT = "(\\s{4})";
    private final List<String>  paragraphList = new ArrayList<>();


    void splitParagraph (String text){
        String[] paragraphs = text.split(PARAGRAPH_SPLIT);
        paragraphList.addAll(Arrays.asList(paragraphs));
    }

    public List<String> getParagraphList() {
        return paragraphList;
    }
    @Override
    public String toString() {
        return "paragraphList: " + paragraphList;
    }
}
