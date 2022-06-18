package chapter9.varianta.helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadAndWriteProperties {
//    public String readFromInputStream(InputStream inputStream) {
//        StringBuilder resultStringBuilder = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                resultStringBuilder.append(line).append("\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultStringBuilder.toString();
//    }
    public String read (String pathInput) {
        Path path = Paths.get(pathInput);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeContentToFile(String pathOutput, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOutput))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}