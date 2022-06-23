package helper.barcketenum;

public enum BracketEnum {
    OPEN_SQUARE('['),
    CLOSE_SQUARE(']'),

    OPEN_PARENTHESES('('),
    CLOSE_PARENTHESES(')'),

    OPEN_BRACE('{'),
    CLOSE_BRACE('}');
    private final char aChar;

    BracketEnum(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }
}
