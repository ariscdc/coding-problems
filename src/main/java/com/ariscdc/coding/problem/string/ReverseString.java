package com.ariscdc.coding.problem.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160210 1405-1408 (3 mins.)
 * 20160210 1435-1440 (5 mins.)
 * 20160210 1450-1452 (2 mins.)
 */
public class ReverseString {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseUsingNewString(String text) {

        if (text == null || text.length() == 1) return text;

        StringBuilder builder = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    // Time Complexity: O(n/2)
    // Space Complexity: O(n)
    public static String reverseUsingSwaps(String text) {

        if (text == null || text.length() == 1) return text;

        char[] reversed = new char[text.length()];
        for (int i = 0, j = text.length() - 1; i <= j; i++, j--) {
            reversed[i] = text.charAt(j);
            reversed[j] = text.charAt(i);
        }
        return String.valueOf(reversed);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseUsingRecursion(String text) {

        if (text == null || text.length() <= 1) return text;
        return reverseUsingRecursion(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println("Reverse using new String:");
        System.out.println(reverseUsingNewString(null));
        System.out.println(reverseUsingNewString(""));
        System.out.println(reverseUsingNewString("A"));
        System.out.println(reverseUsingNewString("ABC"));
        System.out.println(reverseUsingNewString("the quick brown fox jumps over the lazy dog."));

        System.out.println("\n------------------------------");
        System.out.println("Reverse using swaps:");
        System.out.println(reverseUsingSwaps(null));
        System.out.println(reverseUsingSwaps(""));
        System.out.println(reverseUsingSwaps("A"));
        System.out.println(reverseUsingSwaps("ABC"));
        System.out.println(reverseUsingSwaps("the quick brown fox jumps over the lazy dog."));

        System.out.println("\n------------------------------");
        System.out.println("Reverse using Recursion:");
        System.out.println(reverseUsingRecursion(null));
        System.out.println(reverseUsingRecursion(""));
        System.out.println(reverseUsingRecursion("A"));
        System.out.println(reverseUsingRecursion("ABC"));
        System.out.println(reverseUsingRecursion("the quick brown fox jumps over the lazy dog."));
    }
}
