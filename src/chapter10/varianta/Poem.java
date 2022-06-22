package chapter10.varianta;
import helper.helper.PropertiesEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Poem {
    List<String> lengthSorted() {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PropertiesEnum.POEM.getPath()))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }
}

