package chapter4.variantb.Gift.sweets;

public class SweetLogicException extends Exception {
    public SweetLogicException() {
    }

    public SweetLogicException(String message, Throwable exception) {
        super(message, exception);
    }

    public SweetLogicException(String message) {
        super(message);
    }

    public SweetLogicException(Throwable exception) {
        super(exception);
    }
}

