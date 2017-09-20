package com.ariscdc.coding.problem.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ariscdc
 *
 * 20170809 19:17-20:54 (97 mins.)
 */
public class NumberToWordsConverter {

    private static final String[] wordTiers = {
            "", " thousand", " million", " billion", " trillion" };
    private static final String[] wordOnes = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    private static final String[] wordTeens = {
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen" };
    private static final String[] wordTens = {
            "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    private static String toHundreds(int number) {

        List<String> words = new ArrayList<>();

        int hundreds = number / 100;
        if (hundreds > 0) {
            words.add(wordOnes[hundreds - 1]);  // >= 100
            words.add("hundred");
        }

        number %= 100;
        int tens = number / 10;
        int ones = number % 10;

        if (tens > 0) {
            if (tens == 1) {  // >= 10
                if (ones == 0) {
                    words.add(wordTens[tens - 1]);  // 10
                } else {
                    words.add(wordTeens[ones - 1]);  // 11, 12, 13, ...
                }
            } else {
                words.add(wordTens[tens - 1]);  // 20, 30, 40, ...
                if (ones > 0) {
                    words.add(wordOnes[ones - 1]);  // 21, 22, 31, 32, ...
                }
            }
        } else if (ones > 0) {
            words.add(wordOnes[number - 1]);  // < 10
        }

        StringBuilder builder = new StringBuilder();
        if (words.size() > 0) {
            builder.append(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                builder.append(" ").append(words.get(i));
            }
        }
        return builder.toString();
    }

    private static String toWords(int number) {

        if (number == 0) return "zero";

        int tier = 1;
        StringBuilder builder = new StringBuilder();

        while (number > 0) {
            int rem = number % 1000;
            if (rem > 0) {
                if (builder.length() > 0) {
                    builder.insert(0, ", ");
                }
                builder.insert(0, toHundreds(rem) + wordTiers[tier - 1]);
            }
            number = number / 1000;
            tier++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        int[] nums = {
                0, 5, 10, 11, 20, 23, 65, 99, 100, 101, 118, 220, 555, 999,
                1_000, 1_111, 3_000, 3_726, 52_093, 394_900, 5_000_000, 9_999_999, 1_234_567_890
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " = " + toWords(nums[i]));
        }
    }
}
