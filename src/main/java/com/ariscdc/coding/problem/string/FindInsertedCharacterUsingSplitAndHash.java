package com.ariscdc.coding.problem.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20170910 1046-1146 (60 mins.)
 *
 * Time Complexity: O(log n)
 */
public class FindInsertedCharacterUsingSplitAndHash {

    public static Character findInsertedCharacter(String original, String inserted) {
        if (original == null || inserted == null || original.length() != inserted.length() - 1) {
            throw new IllegalArgumentException("Input is invalid.");
        }
        return doFindInsertedCharacter(original, inserted);
    }

    private static Character doFindInsertedCharacter(String original, String inserted) {

        if (original.charAt(0) != inserted.charAt(0)) {
            return inserted.charAt(0);
        }
        if (original.length() == 1 && inserted.length() == 2) {
            return inserted.charAt(1);
        }

        int originalMid = original.length() / 2;
        int insertedMid = inserted.length() / 2;

        String originalLeftHalf = original.substring(0, originalMid);
        String insertedLeftHalf = inserted.substring(0, insertedMid);
        String originalRightHalf = original.substring(originalMid);
        String insertedRightHalf = inserted.substring(insertedMid);

        if (hash(originalLeftHalf) != hash(insertedLeftHalf)) {
            return doFindInsertedCharacter(originalLeftHalf, insertedLeftHalf);
        }
        return doFindInsertedCharacter(originalRightHalf, insertedRightHalf);
    }

    private static int hash(String text) {
        return text.hashCode();
    }

    public static void main(String[] args) {

        String[][] testCases = {
                { "abcd", "abcxd" },
                { "abcd", "aybcd" },
                { "abcd", "zabcd" },
                { "abcd", "abcd" },
                { null, "abcd" },
                { "abcd", "" },
                { "abcd", "abcdefg" },
                { "abcd", "abc" }};

        String result = null;
        for (String[] testCase : testCases) {
            try {
                result = Character.toString(findInsertedCharacter(testCase[0], testCase[1]));
            } catch (Exception e) {
                result = e.getMessage();
            } finally {
                System.out.println(testCase[0] + ", " + testCase[1] + " = " + result);
            }
        }

        /*
        Possible Questions:
        1. Only one inserted character?
        2. This means String with inserted character is always one character greater?
        3. What to return if null or empty?
        4. What to return if not expected String size?
        5. Case sensitive comparison?

        Considerations:
        - Hash Function is not good, high-collision.
        - Need to handle if Hash fails.

        Test Case - Diff in Right Side
        "abcd", "abcxd"

        Call Stack:
        findInsertedCharacterUsingBinarySplitThenHash("d", "xd")
        findInsertedCharacterUsingBinarySplitThenHash("cd", "cxd")
        findInsertedCharacterUsingBinarySplitThenHash("abcd", "abcxd")

        // 01234
        // abcd  // 4/2 = 2
        // abcxd  // 5/2 = 2

        oLH = ab
        iLH = ab
        oRH = cd
        iLH = cxd

        h(cd) != h(cxd)
        -----
        cd  // 2/2 = 1
        cxd  // 3/2 = 1

        oLH = c
        iLH = c
        oRH = d
        iLH = xd

        h(d) != h(xd)
        -----
        d  // 1/2 = 0
        xd  // 2/2 = 1

        oLH = ""
        iLH = x
        oRH = "d"
        iLH = "d"

        =====
        Test Case - Diff in Left Side
        "abcd", "aybcd"

        Call Stack:
        findInsertedCharacterUsingBinarySplitThenHash("b", "y")
        findInsertedCharacterUsingBinarySplitThenHash("ab", "ay")
        findInsertedCharacterUsingBinarySplitThenHash("abcd", "aybcd")

        01234
        abcd  // 4/2 = 2
        aybcd  // 5/2 = 2

        oLH = ab
        iLH = ay
        oRH = cd
        iLH = bcd

        h(ab) != h(ay)
        -----
        ab  // 2/2 = 1
        ay  // 2/2 = 1

        oLH = a
        iLH = a
        oRH = b
        iLH = y

        h(b) != h(y)
        -----
        b
        y

        b != y -> return y

        =====
        Test Case - Diff at start
        "abcd", "zabcd"

        a != y -> return z
        */
    }
}
