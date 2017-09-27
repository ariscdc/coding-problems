package com.ariscdc.coding.algorithm.sort;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 4. Shell Sort
 *
 * Partitions the original list into sub-lists where a sub-list is made of elements separated
 * by an increment. Each sub-list is then sorted using Insertion Sort.
 * The increment is slowly reduced till it is 1.
 * Getting the exact complexity of Shell Sort is hard because it depends on the increment values
 * chosen. It is not clear what the best increment value is.
 * Better that Insertion Sort as the final iteration with increment = 1 has to work with a
 * nearly sorted list.
 *
 * Time Complexity: Somewhere between O(n) and O(n^2)
 *                  For increments 2^k - 1, for k = 1,2,3 ..., complexity is O(n^3/2)
 * Space Complexity: O(1)
 *
 * Stable sort, entities which are equal are maintained in original order.
 * O(n^2) comparisons and O(n^2) swaps
 * Adaptive, able to know and break if list is already sorted.
 *
 * 20160208 1450-1500 (10 mins.)
 * 20160208 1705-1720 (15 mins.)
 * 20160208 1805-1915 (70 mins.)
 *                    (95 mins.)
 */
public class ShellSort {

    public static int[] sort(int[] elements, int increment) {

        if (elements == null || elements.length < 2) return elements;

        System.out.println("Shell Sort:");

        int swaps = 1;
        for (int i = 0; i < increment; i++) {
            for (int j = i; j < elements.length - increment; j += increment) {
                for (int k = j + increment; k >= increment; k -= increment) {
                    if (elements[k] < elements[k - increment]) {
                        swapElements(elements, k - increment, k);
                        print(elements, swaps++);
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println("Insertion Sort:");
        insertionSort(elements, swaps);

        return elements;
    }

    private static int[] insertionSort(int[] elements, int swaps) {

        if (elements == null || elements.length < 2) return elements;

        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (elements[j] < elements[j - 1]) {
                    swapElements(elements, j - 1, j);
                    print(elements, swaps++);
                } else {
                    break;
                }
            }
        }
        return elements;
    }

    private static void print(int[] elements, int step) {

        System.out.printf("%03d: {", step);
        for (int i = 0; i < elements.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(elements[i]);
        }
        System.out.println("}");
    }

    private static void swapElements(int[] elements, int i, int j) {

        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 1, 1 },
                { 3, 3, 3, 3, 3 },
                { 1, 2, 3, 4, 5 },
                { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
                { 8, 2 },
                { 3, 6, 4, 2, 9, 8 },
                { 1, 3, 2, 4, 9, 7, 8, 5, 6, 10 },
                { 1, 3, 2, 1, 9, 7, 0, 5, 3, 8, 6, 4, 3 }
        };
        for (int[] testCase : testCases) {
            System.out.println("------------------------------");
            print(testCase, 0);
            sort(testCase, 2);
            print(testCase, 999);
        }
    }
}
