package chapter4.task1.variantb;

public class TextFile extends File {
    private String content;

    public TextFile(String name, File parent, String content) {
        super(name, parent);
        this.content = content;
    }


    public TextFile(String name, File parent) {
        super(name, parent);
    }


    public TextFile(String content) {
        super();
        this.content = content;
    }


    static TextFile createNew(String name, File parent) {
        return new TextFile(name, parent);
    }


    void addContent(String content) {
        if (this.content == null) {
            this.content = content;
            new TextFile(content);
        } else {
            this.content = getContent() + content;
        }
        new TextFile(content);
    }

    @Override
    void showContent() {
        System.out.println(content);
    }

    @Override
    public File renameTo(String name) {
        return null;
    }


    public TextFile delete(File f) {
        return delete(this);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

