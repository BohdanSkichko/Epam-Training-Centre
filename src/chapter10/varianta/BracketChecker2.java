package chapter10.varianta;

import chapter10.varianta.barcketenum.BracketEnum;

import java.util.ArrayDeque;
import java.util.Deque;

public
class BracketChecker2 {
    public static boolean balancedBracket(String someText) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < someText.length(); i++) {
            Character bracket = someText.charAt(i);
            if (bracket.equals(BracketEnum.OPEN_SQUARE.getaChar()) ||
                    bracket.equals(BracketEnum.OPEN_BRACE.getaChar()) ||
                    bracket.equals(BracketEnum.OPEN_PARENTHESES.getaChar())) {
                deque.push(bracket);
                continue;
            }
            Character check;
            if (bracket.equals(BracketEnum.CLOSE_SQUARE.getaChar())) {
                check = deque.pop();
                if (check.equals(BracketEnum.OPEN_BRACE.getaChar()) || check.equals(BracketEnum.OPEN_PARENTHESES.getaChar()))
                    return false;
            } else if (bracket.equals(BracketEnum.CLOSE_BRACE.getaChar())) {
                check = deque.pop();
                if (check.equals(BracketEnum.OPEN_PARENTHESES.getaChar()) || check.equals(BracketEnum.OPEN_SQUARE.getaChar()))
                    return false;
            } else if (bracket.equals(BracketEnum.CLOSE_PARENTHESES.getaChar())) {
                check = deque.pop();
                if (check.equals(BracketEnum.OPEN_BRACE.getaChar()) || check.equals(BracketEnum.CLOSE_SQUARE.getaChar()))
                    return false;
            }
        }
        return (deque.isEmpty());
    }
}

