package chapter9.varianta.helper;

public enum PropertiesHolder {
    INPUT_PATH("C:\\input.txt"),
    OUT_PATH("C:\\output.txt");

    String s;

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    PropertiesHolder(String path) {

    }

}

