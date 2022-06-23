package chapter10.variantb;

import helper.randomizer.RandomNumberGenerator;

import java.util.*;

public class NumbersStorageStructure {
    private final Set<Integer> numbers = new HashSet<>();

    private void addNumber(int number) {
        numbers.add(number);
    }

    private void addAll(int[] number) {
        for (int element : number)
            numbers.add(element);
    }

    private void removeNumber(int number) {
        numbers.remove(number);
    }

    private Numbers findNumber(int number) {
        if (numbers.contains(number)) {
            return new Numbers(number);
        }
        Set<Integer> newNumbers = new TreeSet<>(numbers);
        newNumbers.add(number);
        List<Integer> index = new ArrayList<>(newNumbers);
        int position = index.indexOf(number);
        int numberRight = index.get(position + 1);
        int numberLeft = index.get(position - 1);
        if (numberRight - number == number - numberLeft) {
            return new Numbers(numberLeft, numberRight);
        } else if (numberRight - number > number - numberLeft) {
            return new Numbers(numberLeft);
        } else
            return new Numbers(numberRight);
    }

    public int find(int number) {
        Iterator<Integer> iterator = numbers.iterator();
        int min = iterator.next();
        while (iterator.hasNext()) {
            int elem = iterator.next();
            if (Math.abs(elem - number) < Math.abs(min - number)) {
                min = elem;
            }
        }
        return min;
    }

    static class Numbers {
        private final int first;
        private int second;

        Numbers(int first) {
            this.first = first;
        }

        Numbers(int numberLeft, int numberRight) {
            this.first = numberLeft;
            this.second = numberRight;
        }


        @Override
        public String toString() {
            return
                    first + " " + +second;

        }


    }

    public static void main(String[] args) {
        NumbersStorageStructure numbersStorageStructure = new NumbersStorageStructure();
        numbersStorageStructure.addAll(RandomNumberGenerator.getNumbers(10, 200));
        System.out.println(numbersStorageStructure.numbers);
        System.out.println(numbersStorageStructure.find(10));
        System.out.println(numbersStorageStructure.numbers);


    }
}
