package chapter9.variantb.task1;


import helper.properties.PropertiesEnum;

import java.io.File;
import java.util.UUID;

public class Runner {
    private static final String SORT_FILE_TEMPLATE = "Sort";

    public static void main(String[] args) {
        File file = new File(PropertiesEnum.EMPTY.getPath());
        FileHelper fileWorker = new FileHelper();
        fileWorker.addRandomNumbersToFile(file, 20, 100);
        fileWorker.writeContentToNewFile(
                SORT_FILE_TEMPLATE + "_" + UUID.randomUUID() + ".txt",
                PropertiesEnum.DIRECTORY.getPath(), fileWorker.sortFileContent(file));
    }
}
