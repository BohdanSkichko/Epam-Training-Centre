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
        if (position == 0) return new Numbers(index.get(1));
        if (position == index.size() - 1) return new Numbers(index.size() - 2);
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
        if (numbers.contains(number)) return number;
        Iterator<Integer> iterator = numbers.iterator();
        int minNUmber = iterator.next();
        while (iterator.hasNext()) {
            int nextNumber = iterator.next();
            if (Math.abs(nextNumber - number) < Math.abs(minNUmber - number)) {
                minNUmber = nextNumber;
            }
        }
        return minNUmber;
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
        numbersStorageStructure.addAll(RandomNumberGenerator.getNumbers(20301, Integer.MAX_VALUE/4));
        System.out.println(numbersStorageStructure.numbers);
        System.out.println(numbersStorageStructure.findNumber(2411));



    }
}
