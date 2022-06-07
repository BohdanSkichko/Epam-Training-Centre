package chapter7.variantb.task1;

import java.util.*;

public class Sentence{
   private static final String SENTENCE_SPLIT = "(?<=(?<![A-Z])\\. )";
   private final  List<String> sentenceList = new ArrayList<>();

   void splitSentence (Paragraph paragraph){
      String[] sentence = Arrays.toString(paragraph.getParagraphList().toArray())
              .replace(".,",".").split(SENTENCE_SPLIT);
      sentenceList.addAll(Arrays.asList(sentence));
   }

   public void sentence (){
      Map<String,Word> wordMap = new HashMap<>();
      for (String sentence : sentenceList){

      }
   }


   @Override
   public String toString() {
      return
              "stringList " + sentenceList;
   }

   public List<String> getStringList() {
      return sentenceList;
   }
}
