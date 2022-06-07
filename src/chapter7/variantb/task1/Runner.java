package chapter7.variantb.task1;

public class Runner {
    public static void main(String[] args) {
        Text text = new Text();
        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        Word word = new Word();

        paragraph.splitParagraph(text.text);
        sentence.splitSentence(paragraph);
        word.splitWord(sentence);
        System.out.println(word.getWordList().size());
    }
}
