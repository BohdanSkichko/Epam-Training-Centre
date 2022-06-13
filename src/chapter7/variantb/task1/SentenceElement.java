package chapter7.variantb.task1;

public abstract class SentenceElement {
    private final String content;

    protected SentenceElement(String content) {
       this.content = content;
    }

    public String getContent() {
        return content;
    }

    public boolean isWord() {
        for (char character : content.toCharArray()) {
            if (Character.isLetter(character)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return
                content;
    }
}
