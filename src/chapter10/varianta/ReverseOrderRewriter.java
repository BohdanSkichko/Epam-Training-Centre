package chapter10.varianta;


import chapter9.varianta.helper.PropertiesEnum;

import java.io.*;
import java.util.ArrayList;


public class ReverseOrderRewriter {
    public void write(File file) {
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
            for (int i = strings.size() - 1; i >= 0; i--) {
                writer.write(strings.get(i)+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
