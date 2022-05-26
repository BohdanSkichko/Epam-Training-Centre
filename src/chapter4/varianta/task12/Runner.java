package chapter4.varianta.task12;

public class Runner {
    public static void main(String[] args) {
        Directory directory1 = Directory.createNew("C:", null);
        Directory directory2 = Directory.createNew("Program files", directory1);
        Directory directory3 = Directory.createNew("Windows", directory2);
        Directory directory4 = Directory.createNew("System", directory3);
        TextFile textFile = TextFile.createNew("File.txt", directory3);





//        textFile.showContent();
//
//        textFile.addContent("Some Text");
//
//        textFile.addContent(" add some Text");
//
//        textFile.showContent();

        directory2.addFile(directory1);
        directory3.addFile(directory2);
        directory4.addFile(textFile);
        directory4.addFile(directory3);
        directory4.showContent();

        System.out.println(directory4.getPathName());


    }
}
