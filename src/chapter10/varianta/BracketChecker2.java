package chapter10.varianta;

import java.util.ArrayDeque;
import java.util.Deque;

public
class BracketChecker2 {
    public static boolean balancedBracket(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                deque.push(x);
                continue;
            }
            if (deque.isEmpty()) return false;
            char check;
            switch (x) {
                case ')':
                    check = deque.pop();
                    if (check == '{' || check == '[') return false;
                    break;
                case '}':
                    check = deque.pop();
                    if (check == '(' || check == '[') return false;
                    break;
                case ']':
                    check = deque.pop();
                    if (check == '(' || check == '{') return false;
                    break;
            }
        }
        return (deque.isEmpty());
    }
    public static void main(String[] args) {
        if (balancedBracket("()([])"))
            System.out.println("True");
        else
            System.out.println("False");
    }
}