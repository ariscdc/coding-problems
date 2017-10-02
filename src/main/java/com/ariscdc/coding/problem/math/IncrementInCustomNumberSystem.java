package com.ariscdc.coding.problem.math;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given a number system, increment a number and return the result.
 *
 * Given number system with 5 digits - 0, A, B, C, D,
 *     1. increment(A) = B
 *     2. increment(D) = A0
 *     3. increment(AD) = B0
 *     4. increment(ABB) = ABC
 *
 * There is another solution:
 *     - Without using decimal conversion - <to be posted>
 *
 * 20160229 0020-0100 (40 mins.)
 */
public class IncrementInCustomNumberSystem {

    private static final char[] digits = { '0', 'A', 'B', 'C', 'D' };

    public static String increment(String number) {
        return toNumberSystem(toDecimal(number) + 1);
    }

    private static int toDecimal(String number) {

        int numberValue = 0;

        for (int i = 0; i < number.length(); i++) {
            double digitValue = Math.pow(digits.length, number.length() - i - 1) * getValue(number.charAt(i));
            numberValue += digitValue;
        }
        return numberValue;
    }

    private static String toNumberSystem(int value) {

        StringBuilder builder = new StringBuilder();

        while (value > 0) {
            int remainder = value % digits.length;
            builder.insert(0, digits[remainder]);
            value /= digits.length;
        }
        return builder.toString();
    }

    private static int getValue(char ch) {

        for (int i = 0; i < digits.length; i++) {
            if (ch == digits[i]) return i;
        }
        throw new IllegalArgumentException("Unrecognized digit - " + ch);
    }

    public static void main(String[] args) {

        //
        //  0 = 5^0 * 0 = 1 * 0 =  0
        //  A = 5^0 * 1 = 1 * 1 =  1
        // AD = 5^1 * 1 = 5 * 1 =  5
        //    = 5^0 * 4 = 1 * 4 =  4
        //                      =  9
        // B0 = 5^1 * 2 = 5 * 2 = 10
        //    = 5^0 * 0 = 1 * 0 =  0
        //                      = 11

        //  0 =  0
        //  A =  1
        //  B =  2
        //  C =  3
        //  D =  4
        // A0 =  5
        // AA =  6
        // AB =  7
        // AC =  8
        // AD =  9
        // B0 = 10

        System.out.println("A -> " + increment("A"));
        System.out.println("D -> " + increment("D"));
        System.out.println("AD -> " + increment("AD"));
        System.out.println("ABB -> " + increment("ABB"));
    }
}
