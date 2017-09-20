package com.ariscdc.coding.algorithm.string;

/**
 * @author ariscdc
 *
 * Also known as NaiveApproachSubstringSearch.
 * Keep iterating theo
 *
 * Time Complexity: O(N x M),
 * where N is the length of source string,
 * and M is the length of the pattern.
 *
 * 20150228 1355-1410 (15 mins.)
 */
public class BruteForceSubstringSearch extends SubstringSearchAlgorithm {

    public int search(String source, String pattern) {

        if (source == null || source.length() == 0 || pattern == null || pattern.length() == 0) {
            return -1;
        }
        for (int i = 0; i <= source.length() - pattern.length(); i++) {
            int j = 0;
            while (source.charAt(i + j) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) return i;
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String source = "This is just a text";
        String sourceUppered = "THIS IS JUST A TEXT";
        String pattern = "just";
        String patternUppered = "JUST";
        String notExistingPattern = "Hello";

        SubstringSearchAlgorithm algorithm = new BruteForceSubstringSearch();

        System.out.println(algorithm.search(source, pattern));
        System.out.println(algorithm.search(source, notExistingPattern));
        System.out.println(algorithm.search(source, patternUppered));
        System.out.println();

        System.out.println(algorithm.searchIgnoreCase(sourceUppered, pattern));
        System.out.println(algorithm.searchIgnoreCase(source, patternUppered));
        System.out.println(algorithm.searchIgnoreCase(source, notExistingPattern));
    }
}
