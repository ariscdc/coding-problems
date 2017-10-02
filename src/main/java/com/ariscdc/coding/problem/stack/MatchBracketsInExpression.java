package com.ariscdc.coding.problem.stack;

import com.ariscdc.coding.ds.stack.Stack;
import com.ariscdc.coding.ds.stack.StackEmptyException;
import com.ariscdc.coding.ds.stack.StackFullException;
import com.ariscdc.coding.ds.stack.StackImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Check whether an expression has well-formed brackets.
 * This means that the opening and closing brackets match.
 * Brackets include:
 *   - Parentheses '(' and ')'
 *   - Curly '{' and '}'
 *   - Square '[' and ']'
 *   - Pointed '<' and '>'
 *
 * Solution:
 * Use a Stack to store the opening brackets each time.
 * For every closing bracket compare to the last element pushed.
 *
 * Time Complexity: O(n), where n is the number of characters
 * Space Complexity: O(n), where n is the number of characters
 *
 * 20160306 1810-1850 (40 mins.)
 */
public class MatchBracketsInExpression {

    private static Map<Character, Character> closingBracketMap = new HashMap<>();
    private static Set<Character> openingBrackets = new HashSet<>();

    static {
        closingBracketMap.put(')', '(');
        closingBracketMap.put('}', '{');
        closingBracketMap.put(']', '[');
        closingBracketMap.put('>', '<');
        openingBrackets = new HashSet<>(closingBracketMap.values());
    }

    public static boolean isValidExpression(String expression) {

        if (expression == null || expression.trim().length() == 0) return false;

        Stack<Character> stack = new StackImpl<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (openingBrackets.contains(ch)) {
                try {
                    stack.push(ch);
                } catch (StackFullException e) {
                    throw new RuntimeException(e);
                }
            } else if (closingBracketMap.containsKey(ch)) {
                try {
                    Character lastOpenBracket = stack.pop();
                    if (!closingBracketMap.get(ch).equals(lastOpenBracket)) {
                        return false;
                    }
                } catch (StackEmptyException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String expression = "";
        System.out.println(expression + " = " + isValidExpression(expression));

        expression = "(A)[abc{gg=123})";
        System.out.println(expression + " = " + isValidExpression(expression));

        expression = "(A)[abc{gg=123}]";
        System.out.println(expression + " = " + isValidExpression(expression));

        expression = "<html><body color=\"#FFCCFF\">${session.name}</body></html>";
        System.out.println(expression + " = " + isValidExpression(expression));

        expression = "<h><b>${s</b></h>";
        System.out.println(expression + " = " + isValidExpression(expression));

        expression = "<<<A";
        System.out.println(expression + " = " + isValidExpression(expression));

        expression = "A}}}";
        System.out.println(expression + " = " + isValidExpression(expression));
    }
}
