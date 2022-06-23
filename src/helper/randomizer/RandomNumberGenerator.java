package helper.randomizer;

public class RandomNumberGenerator {
    public static int[] getNumbers(int numbersQuantity, int numbersRange) {
        int[] array = new int[numbersQuantity];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * numbersRange);
        }
        return array;
    }
}