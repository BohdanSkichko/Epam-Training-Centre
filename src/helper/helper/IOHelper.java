package helper.helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOHelper {
    public  String readFromFile(String inputPath) {
        Path path = Paths.get(inputPath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(String outputPath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendWriteToFile(String outputPath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath,true))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}