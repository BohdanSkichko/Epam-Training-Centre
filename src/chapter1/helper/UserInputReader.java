package chapter1.helper;

import java.util.Scanner;

public class UserInputReader {
    public static int[] getIntUserInput() {
        System.out.print("Enter number quantity: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter numbers: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}
