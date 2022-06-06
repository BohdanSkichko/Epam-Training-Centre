package chapter7.varianta.task8;
//Удалить из текста его часть, заключенную между двумя символами, которые вво-
//дятся (например, между скобками «(» и «)» или между звездочками «*» и т. п.).

public class TextTrimmer {
    public String deleteTextBetweenCharset(String[] input) {
        String s = String.join(" ", input).
                replaceAll("[^a-zA-Z]+", " ");
        String deleteSpace = s.replaceAll("\\s+", " ");
        return deleteSpace.trim();
    }
}
