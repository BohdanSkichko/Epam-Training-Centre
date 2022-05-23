package chapter4.task1.variantb;

public class Runner {
    public static void main(String[] args) {
        File directory1 = Directory.createNew("C:", null);
        Directory directory2 = Directory.createNew("Program files", directory1);
        Directory directory3 = Directory.createNew("Windows", directory2);
        Directory directory4 = Directory.createNew("System", directory3);
        TextFile textFile = TextFile.createNew("File.txt", directory3);
//        c/program files/windows/system
//                                textfile

//        textFile.showContent();
//
//        textFile.addContent("Some Text");
//
//        textFile.addContent(" add some Text");
//
//        textFile.showContent();

        directory2.addFiles(directory1);
        directory3.addFiles(directory2);
        directory4.addFiles(textFile);
        directory4.addFiles(directory3);


    }
}
