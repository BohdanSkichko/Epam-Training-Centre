package chapter6.task5;

public class ModelImpl extends SiemensMobile {

    public ModelImpl(String color, String name, int phoneNumber, int serialnumber) {
        super(color, name, phoneNumber, serialnumber);
    }

    @Override
    public void charge() {
        System.out.println("phone charging");
    }

    @Override
    public void sendMessage(int phoneNumber, String message) {
        checkNumber(phoneNumber);
        System.out.println("send message, phone number " + phoneNumber + " message " + message);
    }
}
