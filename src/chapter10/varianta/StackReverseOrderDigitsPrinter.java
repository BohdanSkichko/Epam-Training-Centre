package chapter10.varianta;

import java.util.Stack;

public class StackReverseOrderDigitsPrinter {
    public void print(int number) {
        Stack<Integer> numbers = new Stack<>();
        while (number > 0) {
            int digit = number % 10;
            numbers.push(digit);
            number = number / 10;
        }
        while (!numbers.isEmpty()) {
            System.out.print(numbers.firstElement());
            numbers.remove(numbers.firstElement());
        }
    }
}
