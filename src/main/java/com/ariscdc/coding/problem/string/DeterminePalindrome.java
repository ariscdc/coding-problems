package com.ariscdc.coding.problem.string;

import static java.lang.Character.toUpperCase;

/**
 * @author ariscdc
 *
 * 20170911 1744-1758 (14 mins.)
 * Time: O(n)
 * Space: O(n)
 */
public class DeterminePalindrome {

    private static boolean isPalindrome(String text) {

        if (text == null || text.trim().length() == 0) {
            return false;
        }
        if (text.length() == 1) {
            return true;
        }

        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            while (text.charAt(left) == ' ') left++;
            while (text.charAt(right) == ' ') right--;
            if (toUpperCase(text.charAt(left++)) != toUpperCase(text.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("ceEC"));
        System.out.println(isPalindrome("comic"));
        System.out.println(isPalindrome("cc"));
        System.out.println(isPalindrome("Lonely Tylenol"));
        System.out.println(isPalindrome("chicken"));

        /*
        ------------------------------
        01234
        madam
        len - 1 = 4
        len / 2 = 2

        i = 0 = m
        4 - i = 4 = m

        i = 1 = a
        4 - i = 3 = a

        i = 2
        exit loop 2 < 2
        return true
        ------------------------------
        0123
        ceEC
        len - 1 = 3
        len / 2 = 2

        i = 0 = c
        3 - i = 3 = c

        i = 1 = e
        3 - i = 2 = e

        i = 2
        exit loop 2 < 2
        return true
        ------------------------------
        01234
        comic
        len - 1 = 4
        len / 2 = 2

        i = 0 = c
        4 - i = 4 = c

        i = 1 = o
        4 - i = 3 = i

        o != i
        return false
        ------------------------------
        01
        cc
        len - 1 = 1
        len / 2 = 1

        i = 0 = c
        1 - i = 1 = c

        i = 1
        exit loop 1 < 1
        return true
         */
    }
}
