package com.ariscdc.coding.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160228 1625-1710 (45 mins.)
 */
public class BoyerMooreSubstringSearch extends SubstringSearchAlgorithm {

    public int search(String source, String pattern) {

        if (source == null || source.length() == 0 || pattern == null || pattern.length() == 0) {
            return -1;
        }
        Map<Character, Integer> badMatchTable = createBadMatchTable(pattern);

        int i = pattern.length() - 1;
        while (i < source.length()) {
            if (source.charAt(i) == pattern.charAt(pattern.length() - 1)) {
                if (checkMatch(source, pattern, i)) {
                    return i - pattern.length() + 1;
                }
            }
            int skipCount = getSkipCount(badMatchTable, pattern, source.charAt(i));
            i += skipCount;
        }
        return -1;
    }

    private boolean checkMatch(String source, String pattern, int startIndex) {

        int sourceIndex = startIndex;
        int patternIndex = pattern.length() - 1;
        while (patternIndex >= 0) {
            if (source.charAt(sourceIndex) != pattern.charAt(patternIndex)) {
                return false;
            }
            sourceIndex--;
            patternIndex--;
        }
        return true;
    }

    private Map<Character, Integer> createBadMatchTable(String pattern) {

        Map<Character, Integer> table = new HashMap<>();
        int patternLength = pattern.length();

        for (int i = 0; i < patternLength; i++) {
            int skipCount = Math.max(1, patternLength - i - 1);
            Integer currentSkipCount = table.get(pattern.charAt(i));
            if (currentSkipCount == null || skipCount < currentSkipCount) {
                table.put(pattern.charAt(i), skipCount);
            }
        }
        return table;
    }

    private int getSkipCount(Map<Character, Integer> badMatchTable, String pattern, char ch) {
        Integer skipCount = badMatchTable.get(ch);
        return skipCount == null ? pattern.length() : skipCount;
    }

    public static void main(String[] args) {

        String source = "This is just a text";
        String pattern = "just";
        String patternUppered = "JUST";
        String notExistingPattern = "Hello";

        SubstringSearchAlgorithm algorithm = new BoyerMooreSubstringSearch();

        System.out.println(algorithm.search(source, pattern));
        System.out.println(algorithm.search(source, patternUppered));
        System.out.println(algorithm.search(source, notExistingPattern));
        System.out.println();

        System.out.println(algorithm.searchIgnoreCase(source, pattern));
        System.out.println(algorithm.searchIgnoreCase(source, patternUppered));
        System.out.println(algorithm.searchIgnoreCase(source, notExistingPattern));
    }
}
