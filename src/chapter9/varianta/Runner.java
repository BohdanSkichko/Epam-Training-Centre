package chapter9.varianta;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        TextRedactor.deleteSubstring("put");
        TextRedactor.replaceSubstring("output", "Input");

    }
}
