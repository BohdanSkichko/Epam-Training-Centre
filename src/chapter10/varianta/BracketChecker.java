package chapter10.varianta;

import chapter10.varianta.barcketenum.BracketEnum;

import java.util.ArrayDeque;
import java.util.Deque;

public class BracketChecker {
    private static boolean isPair(Character first, Character second) {
        return (first.equals(BracketEnum.OPEN_PARENTHESES.getaChar()) && second.equals(BracketEnum.CLOSE_PARENTHESES.getaChar())
                || first.equals(BracketEnum.OPEN_SQUARE.getaChar()) && second.equals(BracketEnum.CLOSE_SQUARE.getaChar())
                || first.equals(BracketEnum.CLOSE_SQUARE.getaChar()) && second.equals(BracketEnum.CLOSE_SQUARE.getaChar()));
    }

    private Deque<Character> getBrackets(String input) {
        Deque<Character> characters = new ArrayDeque<>();
        char[] array = input.toCharArray();
        for (Character brackets : array) {
            if (brackets.equals(BracketEnum.OPEN_PARENTHESES.getaChar()) || brackets.equals(BracketEnum.CLOSE_PARENTHESES.getaChar())
                    || brackets.equals(BracketEnum.OPEN_SQUARE.getaChar()) || brackets.equals(BracketEnum.CLOSE_SQUARE.getaChar())
                    || brackets.equals(BracketEnum.OPEN_BRACE.getaChar()) || brackets.equals(BracketEnum.CLOSE_BRACE.getaChar())) {
                characters.add(brackets);
            }
        }
        return characters;
    }

    private boolean check(String input) {
        Deque<Character> characters = getBrackets(input);
        boolean result = true;
        if (getBrackets(input).size() % 2 != 0) {
            return false;
        } else
            for (int i = 0; i < characters.size(); i++) {
                if (!isPair(characters.removeFirst(), characters.removeLast())) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}
