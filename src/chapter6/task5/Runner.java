package chapter6.task5;

public class Runner {
    public static void main(String[] args) {
        ModelImpl model = new ModelImpl("Red", "CX-75", 674707070, 123449182);
        model.call(123222331);
        model.sendMessage(672330034, "Hello World");
        model.charge();
        System.out.println(model);


    }
}