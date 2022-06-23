package chapter10.varianta;


import helper.properties.PropertiesEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;


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
            ListIterator<String> iterator = strings.listIterator(strings.size());
            while (iterator.hasPrevious()) {
                writer.write(iterator.previous() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
