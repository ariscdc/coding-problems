package com.ariscdc.coding.problem.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20170909 2025-2044 (19 mins.)
 * 20170910 0840-0854 (14 mins.)
 *                    (33 mins.)
 */
public class SwapVowels {

    private static boolean isVowel(char ch) {
        switch (ch) {
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    private static void swap(char[] charArray, int left, int right) {
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
    }

    private static String swapVowels(String text) {

        if (text == null) {
            return null;
        }
        char[] charArray = text.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            while (left < charArray.length && !isVowel(charArray[left])) {
                left++;
            }
            while (left < right && !isVowel(charArray[right])) {
                right--;
            }
            if (left < right) {
                swap(charArray, left++, right--);
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {

        System.out.println(swapVowels("apple"));
        System.out.println(swapVowels("frost"));
        System.out.println(swapVowels("aeio"));
        System.out.println(swapVowels("jklm"));
        System.out.println(swapVowels("friend"));

        /*
        Possible Questions on Requirements:

        1. Case sensitive?
        2. Do I need to swap if the same vowel?
        3. In-place swapping?
        ==============================

        Test Case 1 - Both Ends

        apple
        eppla
        01234

        left = 0 1 3
        right = 4 3

        ------------------------------
        Test Case 2 - Middle

        frost
        01234

        left = 0 2
        right = 4 2

        ------------------------------
        Test Case 3 - All vowels

        aeio
        oeia
        oiea
        0123

        left = 0 1 2
        right = 3 2 1

        ------------------------------
        Test Case 4 - No vowels

        jklm
        0123

        left = 0 1 2 3
        right = 3

        ------------------------------
        Test Case 5 - Even middle

        friend
        freind
        012345

        left = 0 1 2 3
        right = 5 4 3 2
         */
    }
}
