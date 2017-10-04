package com.ariscdc.coding.problem.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20170910 0945-0957 (12 mins.)
 *
 * Time Complexity: (O(n))
 */
public class FindInsertedCharacterUsingNaive {

    public static Character findInsertedCharacter(String original, String inserted) {

        if (original == null || inserted == null || original.length() != inserted.length() - 1) {
            throw new IllegalArgumentException("Input is invalid.");
        }
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != inserted.charAt(i)) {
                return inserted.charAt(i);
            }
        }
        throw new IllegalArgumentException("There is no inserted character.");
    }

    public static void main(String[] args) {

        String[][] testCases = {
                { "abcd", "abcxd" },
                { "abcd", "aybcd" },
                { "abcd", "zabcd" },
                { "abcd", "abcd" },
                { null, "abcd" },
                { "abcd", "" },
                { "abcd", "abcdefg" },
                { "abcd", "abc" }};

        String result = null;
        for (String[] testCase : testCases) {
            try {
                result = Character.toString(findInsertedCharacter(testCase[0], testCase[1]));
            } catch (Exception e) {
                result = e.getMessage();
            } finally {
                System.out.println(testCase[0] + ", " + testCase[1] + " = " + result);
            }
        }
    }
}
