package chapter9.varianta;

import java.io.*;

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
                            result = result.substring(index+lenght);
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

}
