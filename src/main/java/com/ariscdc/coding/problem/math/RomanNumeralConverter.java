package com.ariscdc.coding.problem.math;

import java.util.regex.Pattern;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given a integer, convert it to Roman Numeral.
 *     1. 1 = I
 *     2. 37 = XXXVII
 *     3. 1992 = MCMXCII
 *
 * Given a Roman Numeral, convert it to integer.
 *     1. III = 3
 *     2. XLIX = 49
 *     3. MCMXCII = 1992
 *
 * 20160223 2120-2210 (50 mins.)
 * 20160223 1035-1105 (30 mins.)
 * 20160224 0115-0125 (10 mins.)
 *                    (90 mins.)
 */
public class RomanNumeralConverter {

    private static final int MAX_ROMAN_NUMERAL = 3888;

    private static final char[][] numerals = {
            { 'I', 'V', 'X' },
            { 'X', 'L', 'C' },
            { 'C', 'D', 'M' },
            { 'M', '-', '-' }
    };
    private static final Pattern romanNumeralPattern = Pattern.compile("[IVXLCDM]+");

    public static int toDecimal(String numeral) {

        if (numeral == null || numeral.trim().length() == 0
                || !romanNumeralPattern.matcher(numeral).matches()) {
            throw new IllegalArgumentException("Invalid Roman Numeral - " + numeral);
        }

        int charValue;
        int nextCharValue;
        int numeralValue = 0;
        int i = 0;

        while (i < numeral.length()) {
            char ch = numeral.charAt(i);
            charValue = getNumeralValue(ch);

            if (i + 1 < numeral.length()) {
                nextCharValue = getNumeralValue(numeral.charAt(i + 1));
                if (charValue >= nextCharValue) {
                    numeralValue += charValue;
                } else {
                    numeralValue = numeralValue + (nextCharValue - charValue);
                    i++;
                }
            } else {
                numeralValue += charValue;
            }
            i++;
        }
        return numeralValue;
    }

    public static String toRomanNumeral(int decimal) {

        if (decimal <= 0 || decimal > MAX_ROMAN_NUMERAL) {
            throw new IllegalArgumentException("Number can only be 1 to " + MAX_ROMAN_NUMERAL + ".");
        }

        StringBuilder builder = new StringBuilder();
        int remainder;
        int i = 0;

        while (decimal > 0 && i < numerals.length) {
            remainder = decimal % 10;
            builder.insert(0, getNumeral(remainder, numerals[i++]));
            decimal /= 10;
        }
        return builder.toString();
    }

    private static String getNumeral(int value, char[] numerals) {

        StringBuilder builder = new StringBuilder();

        if (value == 9) {
            builder.append(numerals[0]).append(numerals[2]);

        } else if (value >= 5) {
            builder.append(numerals[1]);
            for (int i = 6; i <= value; i++) {
                builder.append(numerals[0]);
            }
        } else if (value == 4) {
            builder.append(numerals[0]).append(numerals[1]);

        } else if (value >= 1){
            for (int i = 1; i <= value; i++) {
                builder.append(numerals[0]);
            }
        }
        return builder.toString();
    }

    private static char getNumeralValue(char numeral) {

        switch (numeral) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Invalid numeral - " + numeral);
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " = " + toRomanNumeral(i));
        }
        System.out.println("37 = " + toRomanNumeral(39));
        System.out.println("1992 = " + toRomanNumeral(1992));

        System.out.println();
        System.out.println("MCMXCII = " + toDecimal("MCMXCII"));
        System.out.println("XLIX = " + toDecimal("XLIX"));
        System.out.println("MMMDCCCLXXXVIII = " + toDecimal("MMMDCCCLXXXVIII"));
    }
}
