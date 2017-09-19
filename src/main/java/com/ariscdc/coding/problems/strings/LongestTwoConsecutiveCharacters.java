package com.ariscdc.coding.problems.strings;

/**
 * @author ariscdc
 *
 * 20170810 2010-2055 (45 mins.)
 */
public class LongestTwoConsecutiveCharacters {

    private static String longestTwoConsecutiveCharacters(String text) {

        if (text == null || text.length() < 2) return "";

        int index = 0;
        String longest = "";

        while (index < text.length()) {
            int firstIndex = index;
            int runningIndex = firstIndex + 1;
            if (runningIndex == text.length()) break;

            while (runningIndex < text.length() && text.charAt(runningIndex) == text.charAt(firstIndex)) {
                runningIndex++;
            }
            if (runningIndex == text.length()) break;

            int secondIndex = runningIndex;
            runningIndex++;
            while (runningIndex < text.length() && text.charAt(runningIndex) == text.charAt(secondIndex)) {
                runningIndex++;
            }

            String candidate = text.substring(firstIndex, runningIndex > text.length() ? text.length() : runningIndex);
            if (candidate.length() > longest.length()) {
                longest = candidate;
            }
            index = secondIndex;
        }

        return longest;
    }

    public static void main(String[] args) {

        System.out.println(longestTwoConsecutiveCharacters(null));
        System.out.println(longestTwoConsecutiveCharacters(""));
        System.out.println(longestTwoConsecutiveCharacters("a"));
        System.out.println(longestTwoConsecutiveCharacters("aaaa"));
        System.out.println(longestTwoConsecutiveCharacters("ab"));
        System.out.println(longestTwoConsecutiveCharacters("abb"));
        System.out.println(longestTwoConsecutiveCharacters("aabb"));
        System.out.println(longestTwoConsecutiveCharacters("abbcddddddddd"));
        System.out.println(longestTwoConsecutiveCharacters("abbbbbcdefghhijjjj"));
    }
}
