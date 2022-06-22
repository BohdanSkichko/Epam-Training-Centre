package chapter10.variantb;

import java.util.ArrayList;
import java.util.List;


public class Sorter {
    public ArrayList<Integer> sort(int numbersQuantity, int rangeNumber) {
        ArrayList<Integer> integers = new ArrayList<>();
        int[] array = new int[numbersQuantity];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * rangeNumber);
            integers.add(array[i]);
        }
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i + 1; j < integers.size(); j++) {
                if (integers.get(i) > integers.get(j)) {
                    swap(integers, i, j); // Collections.swap(integers,i,j);
                }
            }
        }
        return integers;
//     return (ArrayList<Integer>) integers.stream()
//             .sorted(Comparator.comparing(Integer::intValue))
//             .collect(Collectors.toList());
    }

    private static void swap(List<Integer> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
