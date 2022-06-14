package chapter4.varianta.task1;

public class Runner {
    public static void main(String[] args) {
        Word word4 =new Word(null);
        Word word = new Word("hello");
        Word word1 = new Word("   java");
        Word word2 = new Word("   one");
        Word word3 = new Word("two   ");

        Sentence sentence = new Sentence();
        sentence.addWord(word4);
        sentence.addWord(word);
        sentence.addWord(word1);
        sentence.addWord(word);
        sentence.addWord(word);


        Sentence sentence1 = new Sentence();
        sentence1.addWord(word2);
        sentence1.addWord(word3);


        TextImp text = new TextImp();
        text.addSentence(sentence);
        text.addSentence(sentence1);
        text.addSentence(sentence);
        text.addSentence(sentence1);
        text.addSentence(sentence1);

        text.setHeader("Hello World");
        text.printHeader();
        text.printText();




    }
}
