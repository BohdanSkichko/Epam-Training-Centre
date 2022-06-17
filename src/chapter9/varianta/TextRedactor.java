package chapter9.varianta;


import chapter7.variantb.task1.Sentence;
import chapter7.variantb.task1.SentenceElement;
import chapter7.variantb.task1.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextRedactor {
    static void deleteSubstring(String someString) {
        try (InputStream input = TextRedactor.class.getClassLoader().getResourceAsStream("config.properties")) {
            assert input != null;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    input));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                         "C:\\Users\\Nick\\kre\\src\\resources\\configEdit.properties"))) {
                String read;
                String result;
                int lenght = someString.length();
                while ((read = bufferedReader.readLine()) != null) {
                    int index = read.indexOf(someString);
                    if (index != -1) {
                        result = read;
                        while (index != -1) {
                            bufferedWriter.write(result.substring(0, index));
                            result = result.substring(index + lenght);
                            index = result.indexOf(someString);
                            if (index == -1) bufferedWriter.write(result + "\r\n");
                        }
                    } else {
                        bufferedWriter.write(read + "\r\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replaceSubstring(String someSubstring, String newSubstring) {
        try (InputStream input = TextRedactor.class.getClassLoader().getResourceAsStream("config.properties")) {
            assert input != null;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    input));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                         "C:\\Users\\Nick\\kre\\src\\resources\\configEdit.properties"))) {
                String read;
                String result;
                int lenght = someSubstring.length();
                while ((read = bufferedReader.readLine()) != null) {
                    int index = read.indexOf(someSubstring);
                    if (index != -1) {
                        result = read;
                        while (index != -1) {
                            bufferedWriter.write(result.substring(0, index));
                            bufferedWriter.write(newSubstring);
                            result = result.substring(index + lenght);
                            index = result.indexOf(someSubstring);
                            if (index == -1) bufferedWriter.write(result + "\r\n");
                        }
                    } else {
                        bufferedWriter.write(read + "\r\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordsWithFirstVowelLetter() {
        List<String> words = new ArrayList<>();
        try (InputStream input = TextRedactor.class.getClassLoader().getResourceAsStream("config.properties")) {
            assert input != null;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    input))) {
                String read;
                while ((read = bufferedReader.readLine()) != null) {
                    for (SentenceElement word : new Sentence(read).getSentenceElements()) {
                        if (word instanceof Word && ((Word) word).isFirstVowelLetter()) {
                            words.add(String.valueOf(word));

                        }
                    }
                }

            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public void printWordsLastLetterEqualsFirstLetterNext() {
        List<String> words = new ArrayList<>();
        try (InputStream input = TextRedactor.class.getClassLoader().getResourceAsStream("config.properties")) {
            assert input != null;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    input))) {
                String read;
                while ((read = bufferedReader.readLine()) != null) {
                    for (SentenceElement word : new Sentence(read).getSentenceElements()) {
                        if (word instanceof Word) {
                            words.add(String.valueOf(word));

                        }
                    }
                }
                for (int i = 0; i < words.size() - 1; i++) {
                    int first = 0;
                    int last = words.get(i).length() - 1;
                    if (words.get(i).charAt(last) == (words.get(i + 1).charAt(first))) {
                        System.out.println("first word: " + words.get(i) + " second word: " + words.get(i + 1));
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}