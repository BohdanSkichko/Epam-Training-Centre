package chapter6.task5;

public abstract class SiemensMobile {
    private final String color;
    private final String name;
    private final int phoneNumber;
    private final int serialnumber;

    public SiemensMobile(String color, String name, int phoneNumber, int serialnumber) {
        this.color = color;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.serialnumber = serialnumber;
    }

    public void checkNumber(int number) {
        String s = Integer.toString(number);
        if (s.length() < 9) throw new IllegalArgumentException("incorrect number");
    }

    public void calling(int enterNumber) {
        checkNumber(enterNumber);
        System.out.println("calling " + enterNumber);
    }


    @Override
    public String toString() {
        return "SiemensMobile " +
                "color " + color + '\'' +
                "name " + name + '\'' +
                "phoneNumber " + phoneNumber + '\'' +
                "serialnumber " + serialnumber;
    }
}
