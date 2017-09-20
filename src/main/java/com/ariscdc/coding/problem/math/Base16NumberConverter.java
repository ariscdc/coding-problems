package com.ariscdc.coding.problem.math;

/**
 * @author ariscdc
 *
 * 20170906 2030-2041 (11 mins.)
 */
public class Base16NumberConverter {

    private static final String[] hexChars =
            { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

    private static String decimalToHex(int decimal) {

        if (decimal < 0) {
            throw new IllegalArgumentException("Number to convert should be greater than zero.");
        }
        int num = decimal;
        String hex = "";

        while (num > 0) {
            int remainder = num % 16;
            String hexChar = hexChars[remainder];
            hex = hexChar + hex;
            num = num / 16;
        }
        return hex;
    }

    public static void main(String[] args) {

        int decimal = 2321;

        String hex = Base16NumberConverter.decimalToHex(decimal);
        System.out.println(hex);
    }
}
