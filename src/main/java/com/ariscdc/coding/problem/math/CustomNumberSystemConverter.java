package com.ariscdc.coding.problem.math;

/**
 * @author ariscdc
 *
 * 20160906 2043-2107 (24 mins.)
 */
public class CustomNumberSystemConverter {

    private static final String[] baseCustom =
            { "A", "T", "t", "l", "a", "S", "s", "i", "@", "n" };
    private static final String[] base2 =
            { "0", "1" };
    private static final String[] base8 =
            { "0", "1", "2", "3", "4", "5", "6", "7" };
    private static final String[] base10 =
            { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    private static final String[] base16 =
            { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    private static final String[] base62 = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z" };

    private static String decimalToCustomNumber(long decimal, String[] numberChars) {

        if (decimal < 0) {
            throw new IllegalArgumentException("Number to convert should be greater than zero.");
        }
        long num = decimal;
        String result = "";

        while (num > 0) {
            long remainder = num % numberChars.length;
            String numberChar = numberChars[(int) remainder];
            result = numberChar + result;
            num = num / numberChars.length;
        }
        return result;
    }

    public static void main(String[] args) {

        long decimal = 817121679138029L;

        System.out.println(decimal + " = " + decimalToCustomNumber(decimal, baseCustom) + " - base" + baseCustom.length);
        System.out.println(decimal + " = " + decimalToCustomNumber(decimal, base2) + " - base" + base2.length);
        System.out.println(decimal + " = " + decimalToCustomNumber(decimal, base8) + " - base" + base8.length);
        System.out.println(decimal + " = " + decimalToCustomNumber(decimal, base10) + " - base" + base10.length);
        System.out.println(decimal + " = " + decimalToCustomNumber(decimal, base16) + " - base" + base16.length);
        System.out.println(decimal + " = " + decimalToCustomNumber(decimal, base62) + " - base" + base62.length);
    }
}
