package com.ariscdc.coding.problem.string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given a string, return the first non-repeated character.
 *
 * 20170919 1900-1945 (45 mins.)
 *                    (~30 mins. solution design)
 * Time: O(n) - Need to iterate each character in String.
 * Space: O(n) - Worst case all characters are unique.
 */
public class FirstNonRepeatingCharacter {

    private Character findFirstNonRepeatingCharacter(String text) {

        LinkedHashSet<Character> charactersRead = new LinkedHashSet<>();
        Set<Character> duplicateCharacters = new HashSet<>();

        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Input text is invalid.");
        }

        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            if (charactersRead.contains(ch)) {
                charactersRead.remove(ch);
                duplicateCharacters.add(ch);

            } else if (!duplicateCharacters.contains(ch)){
                charactersRead.add(ch);
            }
        }
        if (!charactersRead.isEmpty()) {
            return charactersRead.iterator().next();
        } else {
            throw new IllegalArgumentException("No non-repeating character found.");
        }
    }

    public static void main(String[] args) {

        FirstNonRepeatingCharacter app = new FirstNonRepeatingCharacter();

        System.out.println("abcdab" + " = " + app.findFirstNonRepeatingCharacter("abcdab"));
        System.out.println("abcdcd" + " = " + app.findFirstNonRepeatingCharacter("abcdcd"));
        System.out.println("aaab" + " = " + app.findFirstNonRepeatingCharacter("aaab"));
        System.out.println("abbb" + " = " + app.findFirstNonRepeatingCharacter("abbb"));
        System.out.println("abcdefghijklmnopqrstuvwxyz" + " = " + app.findFirstNonRepeatingCharacter("abcdefghijklmnopqrstuvwxyz"));

        try {
            String text = null;
            System.out.print(text + " = ");
            app.findFirstNonRepeatingCharacter(text);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            String text = "";
            System.out.print(text + " = ");
            app.findFirstNonRepeatingCharacter(text);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            String text = "abab";
            System.out.print(text + " = ");
            app.findFirstNonRepeatingCharacter(text);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
