package chapter9.variantb.task1;

import chapter9.varianta.helper.IOHelper;


import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File file = new File("Text.txt");
        FileWorker fileWorker = new FileWorker();
        fileWorker.addRandomNumbersToFile(file, 20);
        fileWorker.writeContentToNewFile("Test2.txt", "C:\\directory\\A", fileWorker.sortFileContent(file));
    }
}
