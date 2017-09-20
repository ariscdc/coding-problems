package com.ariscdc.coding.problem.math;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160217 1150-1205 (15 mins.)
 */
public class HexToDecimal {

    private static final char[] hexChars =
            { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static int toDecimal(String hex) {

        if (hex == null || hex.length() == 0)
            throw new IllegalArgumentException("Hex number input is null or empty.");

        String hexLower = hex.toLowerCase();

        int value = 0;
        for (int i = 0; i < hexLower.length(); i++) {
            char ch = hexLower.charAt(i);
            double charValue = getDecimalValue(ch) * Math.pow(16, (hexLower.length() - 1) - i);
            value += charValue;
        }
        return value;
    }

    private static int getDecimalValue(char ch) {
        for (int i = 0; i < hexChars.length; i++) {
            if (ch == hexChars[i]) return i;
        }
        throw new IllegalArgumentException("Invalid hex number.");
    }

    public static void main(String[] args) {

        System.out.println("0 = " + toDecimal("0"));
        System.out.println("A = " + toDecimal("A"));
        System.out.println("FF = " + toDecimal("FF"));
        System.out.println("ff = " + toDecimal("ff"));
        System.out.println("100 = " + toDecimal("100"));
        System.out.println("ffcc71abc = " + toDecimal("ffcc71abc"));
    }
}
