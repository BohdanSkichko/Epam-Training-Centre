package chapter9.varianta;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream(
                "C:\\Users\\Nick\\kre\\src\\resources\\config.properties")) {

            Properties prop = new Properties();

            prop.setProperty("content", "The \"standard\" error output stream? This stream is already open and " +
                    "ready to accept output data. \n" +
                    "Typically this stream corresponds to display output or another output destination specified " +
                    "by the host environment or user. By convention, this output stream is used to display error " +
                    "sages or other information that should come to the immediate attention of a user even if the " +
                    "principal output stream, the value of the variable out, has been redirected to a file or other" +
                    " destination that is typically not continuously monitored.");

            prop.store(output, "write content");

        } catch (IOException io) {
            io.printStackTrace();
        }


        TextRedactor.deleteSubstring("put");
        TextRedactor.replaceSubstring("output", "Input");
        TextRedactor textRedactor = new TextRedactor();
        System.out.println(textRedactor.getWordsWithFirstVowelLetter());
        textRedactor.printWordsLastLetterEqualsFirstLetterNext();

    }
}
