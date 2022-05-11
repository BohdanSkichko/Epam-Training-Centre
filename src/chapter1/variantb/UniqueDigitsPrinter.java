package chapter1.variantb;

import java.util.HashSet;
import java.util.Set;

public class UniqueDigitsPrinter {
    public void printUniqueNumbers() {
        for (int i = 100; i <= 999; i++) {
            int a = i / 100; // 1-9
            int b = (i / 10) % 10; // (11/10) %  10 = 1
            int c = i % 10; // 10 % 10 = 1
            if (a != b && b != c && c != a) {
                System.out.println(i);
            }
        }
    }

    public void printUniqueNumbers(int[] numbers) {
        for (int number : numbers) {
            String strNum = Integer.toString(number);
            if (strNum.length() != 3) continue;
            char[] chrNum = strNum.toCharArray();
            Set<Character> charSet = new HashSet<>();
            for (char c : chrNum) {
                charSet.add(c);

            }
            if (charSet.size() == 3) {
                System.out.println(strNum);
            }
        }
    }
}
