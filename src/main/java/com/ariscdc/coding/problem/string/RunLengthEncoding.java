package com.ariscdc.coding.problem.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Compress string by counting the number of succeeding characters in the sequence
 * and then store the count and the character to repeat.
 *
 * Example:
 * "AABBCCC" -> "1A2B3C"
 * "1D2E1F" -> "DEEF"
 *
 * 20160226 1900-1920 (20 mins.)
 * 20160226 1925-1940 (15 mins.)
 *                    (35 mins.)
 */
public class RunLengthEncoding {

    public static String encode(String text) {

        if (text == null || text.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input string - " + text);
        }
        if (text.length() == 1) return "1" + text;

        int count = 1;
        char lastChar = text.charAt(0);
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == lastChar) {
                count++;
            } else {
                builder.append(count).append(lastChar);
                lastChar = ch;
                count = 1;
            }
        }
        builder.append(count).append(lastChar);
        return builder.toString();
    }

    public static String decode(String text) {

        if (text == null || text.trim().length() < 2) {
            throw new IllegalArgumentException("Invalid input string - " + text);
        }

        StringBuilder builder = new StringBuilder();
        String count = "";
        boolean paired = true;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                count += ch;
                paired = false;
            } else {
                if (paired) {
                    throw new IllegalArgumentException("Invalid input string. Expecting number - " + text);
                }
                for (int j = 0; j < Integer.parseInt(count); j++) {
                    builder.append(ch);
                }
                count = "";
                paired = true;
            }
        }
        if (!paired) {
            throw new IllegalArgumentException("Invalid input string. Expecting character - " + text);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println("A -> " + encode("A"));
        System.out.println("AAB -> " + encode("AAB"));
        System.out.println("ABB -> " + encode("ABB"));
        System.out.println("ABBCCCDDDDEEEFFG -> " + encode("ABBCCCDDDDEEEFFG"));
        System.out.println();

        System.out.println("1A -> " + decode("1A"));
        System.out.println("2A1B -> " + decode("2A1B"));
        System.out.println("1A2B -> " + decode("1A2B"));
        System.out.println("1A2B3C4D3E2F1G -> " + decode("1A2B3C4D3E2F1G"));
        System.out.println("11A -> " + decode("11A"));
        System.out.println("12A6B3C -> " + decode("12A6B3C"));
    }
}
