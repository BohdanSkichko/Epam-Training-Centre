//package chapter11.task1;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Queue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class Pier implements Iterable<Container> {
//    public static final int DEFAULT_STORAGE_CAPACITY = 20;
//    private Queue<Container> containers = null;
//
//    private Pier() {
//        containers =
//                new LinkedBlockingQueue<Container>(DEFAULT_STORAGE_CAPACITY);
//    }
//
//    private Pier(int capacity) {
//        containers = new LinkedBlockingQueue<Container>(capacity);
//    }
//
//    public static Pier createStorage(int capacity) {
//        return new Pier(capacity);
//    }
//
//    public static Pier createStorage(int capacity, List<Container> goods) {
//        Pier storage = new Pier(capacity);
//        storage.containers.addAll(goods);
//        return storage;
//    }
//
//    public Container getContainer() {
//        return containers.poll();
//    }
//
//    public boolean setContainer(Container container) {
//        return containers.add(container);
//    }
//
//    @Override
//    public Iterator<Container> iterator() {
//        return containers.iterator();
//    }
//}
//
