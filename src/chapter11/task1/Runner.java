package chapter11.task1;

public class Runner {
    public static void main(String[] args) {
        Port port = new Port("Odessa", 400_000);
        Ship ship = new Ship("First", 2_000, port);
        Ship ship1 = new Ship("Second", 20_000,port);
        ship.run();
        ship1.run();
    }
}
