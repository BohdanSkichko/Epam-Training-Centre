package chapter6.task5;

public interface IMobile <T extends SiemensMobile> {
    void charging();
    void sendMessage(int phone,String message);
}
