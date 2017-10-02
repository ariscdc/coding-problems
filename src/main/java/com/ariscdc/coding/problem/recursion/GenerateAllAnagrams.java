package com.ariscdc.coding.problem.recursion;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Anagrams are words formed by rearranging the letters of another word. These may not be valid words.
 * Given a word, generate all its anagrams.
 *
 * This will find all permutations of the letters and if all letters are unique then there are n! anagrams.
 *
 * Base Case:
 * The Anagram of one character is itself.
 *
 * Recursive Case:
 * Find Anagrams of smaller words by removing the first character of the original word.
 * Add removed character one by one at every position for each returned sub-anagrams.
 * As the recursive call stack unwinds, the final call contains all Anagrams.
 *
 * Time Complexity: O(n!), since the number of Anagrams for a given word is n!
 * This cannot be further optimized.
 *
 * 20160212 1300-1315 (15 mins.)
 * 20160220 1910-1935 (25 mins.)
 *                    (40 mins.)
 */
public class GenerateAllAnagrams {

    public static Set<String> generate(String word) {

        Set<String> anagrams = new LinkedHashSet<>();
        if (word == null || word.length() == 0) return anagrams;

        if (word.length() == 1) {
            anagrams.add(word);
            return anagrams;
        }

        char ch = word.charAt(0);
        Set<String> subAnagrams = generate(word.substring(1));

        for (String subAnagram: subAnagrams) {
            for (int pos = 0; pos < subAnagram.length(); pos++) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < subAnagram.length(); i++) {
                    if (i == pos) builder.append(ch);
                    builder.append(subAnagram.charAt(i));
                }
                anagrams.add(builder.toString());
            }
            anagrams.add(subAnagram + ch);
        }
        return anagrams;
    }

    public static void main(String[] args) {

        String[] words = { null, "", "A", "AB", "ABC", "ABCD", "ABCDE" };

        for (String word: words) {
            Set<String> anagrams = generate(word);
            System.out.println("[" + word + "] - " + anagrams.size() + " - " + anagrams);
        }
    }
}
