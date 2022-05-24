package chapter4.varianta.task12;

public class TextFile extends File {
    private String content;

    public TextFile(String name, Directory parent, String content) {
        super(name, parent);
        this.content = content;
    }


    public TextFile(String name, Directory parent) {
        super(name, parent);
    }


    public TextFile(String content) {
        super();
        this.content = content;
    }


    static TextFile createNew(String name, Directory parent) {
        return new TextFile(name, parent);
    }


    void addContent(String content) {
        if (this.content == null) {
            this.content = content;
            new TextFile(content);
        } else {
            this.content = getContent() + content;
        }
    }

    @Override
    void showContent() {
        System.out.println(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

