package chapter9.variantb.task1;


import helper.helper.PropertiesEnum;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File file = new File(PropertiesEnum.EMPTY.getPath());
        FileHelper fileWorker = new FileHelper();
        fileWorker.addRandomNumbersToFile(file, 20,100);
        fileWorker.writeContentToNewFile(
                "Sort.txt", PropertiesEnum.DIRECTORY.getPath(), fileWorker.sortFileContent(file));
    }
}
