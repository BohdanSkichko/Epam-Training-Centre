package chapter10.varianta;

import java.util.ArrayDeque;
import java.util.Deque;

public class BracketChecker {
    private static boolean isReverse(char first, char second) {
        return (first == '(' && second == ')' || first == '[' && second == ']' || first == '{' && second == '}');
    }

    private Deque<Character> getElements(String input) {
        Deque<Character> characters = new ArrayDeque<>();
        char[] array = input.toCharArray();
        for (char c : array) {
            if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
                characters.add(c);
            }
        }
        return characters;
    }
    private boolean check(String input) {
        boolean check = true;
        if (getElements(input).size() % 2 != 0) {
            return false;
        } else
            for (int i = 0; i < getElements(input).size(); i++) {
                if (!isReverse(getElements(input).removeFirst(), getElements(input).removeLast())) {
                    check = false;
                    break;
                }
            }
        return check;
    }


    public static void main(String[] args) {
        BracketChecker bracketChecker = new BracketChecker();
        System.out.println(bracketChecker.check("([])"));
    }
}
