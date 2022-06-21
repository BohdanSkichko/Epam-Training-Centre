package chapter9.variantb.task1;

import chapter9.varianta.helper.IOHelper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class FileWorker {
    void addRandomNumbersToFile(File file, int quantityNumbers) {
        IOHelper ioHelper = new IOHelper();
        int[] array = new int[quantityNumbers];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 100) - 15);
            ioHelper.appendWriteToFile(String.valueOf(file), (array[i] + " "));
        }
    }

    public String sortFileContent(File file) {
        IOHelper ioHelper = new IOHelper();
        String content = ioHelper.readFromFile(String.valueOf(file));
        String[] array = content.split(" ");
        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(numbers);
        return Arrays.toString(numbers);

    }

    public void writeContentToNewFile(String fileName, String directory, String content) {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            File newFile = new File(dir.getAbsolutePath(), fileName);
            System.out.println("Final filepath : " + newFile.getAbsolutePath());
            if (newFile.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File is already existed!");
            }
            IOHelper ioHelper = new IOHelper();
            ioHelper.writeToFile(newFile.getAbsolutePath(), content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
