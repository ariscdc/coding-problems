package com.ariscdc.coding.problem.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20170910 1615-1627 (12 mins.)
 *
 * Time Complexity: O(m + n) - Iterate each element of original (m) and inserted (n)
 */
public class FindInsertedCharacterUsingXOR {

    private static Character findInsertedCharacter(String original, String inserted) {

        if (original == null || inserted == null || original.length() != inserted.length() - 1) {
            throw new IllegalArgumentException("Input is invalid - original=" + original + ", inserted=" + inserted);
        }

        int originalXorResult = 0;
        for (int i = 0; i < original.length(); i++) {
            originalXorResult ^= original.charAt(i);
        }
        int insertedXorResult = 0;
        for (int i = 0; i < inserted.length(); i++) {
            insertedXorResult ^= inserted.charAt(i);
        }
        return (char) (originalXorResult ^ insertedXorResult);
    }

    public static void main(String[] args) {

        System.out.println(findInsertedCharacter("abcd", "awbcd"));
        System.out.println(findInsertedCharacter("abcd", "abcxd"));
        System.out.println(findInsertedCharacter("abcd", "yabcd"));
        System.out.println(findInsertedCharacter("abcd", "abcdz"));

        try {
            System.out.println(findInsertedCharacter("abcd", "abcd"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
