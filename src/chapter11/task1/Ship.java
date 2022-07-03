package chapter11.task1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Phaser;

public class Ship implements Runnable {
    private final int MAX_QUANTITY_CONTAINERS = 20_000;
    private String name;
    int capacityContainer;
    private Port port;


    public Ship(String name, int capacityContainer, Port port) {
        this.name = name;
        this.capacityContainer = capacityContainer;
        this.port = port;
    }

    private synchronized void loadShip() {
        for (int i = 0; i < MAX_QUANTITY_CONTAINERS; i++) {
            if (port.getCurrentContainersQuantity() > 1) {
                capacityContainer++;
                port.takeContainer();
            }
        }
        System.out.println("Ship " + name + " load containers: " + capacityContainer);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private synchronized void unloadShip() {
        int size = capacityContainer;
        for (int i = 0; i < size; i++) {
            capacityContainer--;
            port.addContainer();
        }
        System.out.println("Ship " + name + " unload container " + "current container: " + capacityContainer +
                "containerPort" + port.getCurrentContainersQuantity());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void goShip() {
        try {
            Thread.sleep(new Random(100).nextInt(500));
            System.out.println("Ship " + name + " начал поездку.");
            Thread.sleep(new Random(100).nextInt(1000));
            System.out.println("Ship " + name + " завершил поездку.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        loadShip();
        unloadShip();
    }
}
