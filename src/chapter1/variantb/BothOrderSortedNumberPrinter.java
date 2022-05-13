package chapter1.variantb;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BothOrderSortedNumberPrinter {
    public void printSorted(int[] number) {
        Arrays.sort(number);
        System.out.println(Arrays.toString(number));
        Integer[] IntegerNumber = IntStream.of(number).boxed().toArray(Integer[]::new);
        Arrays.sort(IntegerNumber, Collections.reverseOrder());
        System.out.println(Arrays.toString(IntegerNumber));


        /*List<Integer> inputList = IntStream.of(number).boxed().collect(Collectors.toList());
        Collections.sort(inputList);
        inputList.forEach(System.out::println);
        inputList.sort(Comparator.reverseOrder());
        inputList.forEach(System.out::println);*/
    }

    public void printSortedArray(int[] number) {
        for (int i = 0; i < number.length; i++) {
            int min = number[i];
            int index = i;
            for (int j = i + 1; j < number.length; j++) {
                if (number[j] > min) {            // number[j]<min
                    min = number[j];
                    index = j;
                }
                if (i != index) {
                    int buf = number[i];
                    number[i] = number[index];
                    number[index] = buf;
                }

            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(number));
    }
}
