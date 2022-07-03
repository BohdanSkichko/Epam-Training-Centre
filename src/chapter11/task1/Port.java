package chapter11.task1;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class Port {
    private final int MAX_QUANTITY_CONTAINER = 400_000;
    private static int PIER_SIZE = 5;

    private String name;
    private final Semaphore semaphore = new Semaphore(PIER_SIZE, true);
    private int currentContainersQuantity;
    private final Queue<Thread> ships = new LinkedList<>();

    public Port(String name, int currentContainersQuantity) {
        this.name = name;
        this.currentContainersQuantity = currentContainersQuantity;
    }

    public void addContainer() {
        currentContainersQuantity++;
    }

    public void takeContainer() {
        currentContainersQuantity--;
    }

    public synchronized void askPermission() {
        while (PIER_SIZE == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ships.add(Thread.currentThread());
        PIER_SIZE--;
        System.out.println(Thread.currentThread().getName() + " has received permission, free docks: " + PIER_SIZE);
    }

    public synchronized void returnPermission() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is leaving dock");

        System.out.println("Current containers in Port: " + currentContainersQuantity);

        if (ships.contains(Thread.currentThread())) {
            PIER_SIZE++;
        }
        ships.remove(Thread.currentThread());
        notifyAll();
    }


    public int getCurrentContainersQuantity() {
        return currentContainersQuantity;
    }
}
