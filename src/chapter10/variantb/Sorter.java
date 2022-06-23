package chapter10.variantb;

import helper.randomizer.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Sorter {
    private List<Integer> getRandomNumberList(int numbersQuantity, int numbersRange) {
        List<Integer> integers = new ArrayList<>();
        int [] numbers = RandomNumberGenerator.getNumbers(numbersQuantity,numbersRange);
        for (int num : numbers){
            integers.add(num);
        }
        return integers;

    }

    public List<Integer> sort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    Collections.swap(list, i, j);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        System.out.println(sorter.sort(sorter.getRandomNumberList(20,100)));
    }
}
