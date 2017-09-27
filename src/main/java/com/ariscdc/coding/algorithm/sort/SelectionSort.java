package com.ariscdc.coding.algorithm.sort;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 1. Selection Sort
 *
 * Selects one element at a time, compares it to all other elements in the list.
 * The correct position for that selected element is found before moving on to the next element.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Not a Stable sort, entities which are equal might be re-arranged.
 * O(n^2) comparisons and O(n) swaps
 * Not Adaptive, not a way to know if list is nearly-sorted.
 *
 * 20160207 1630-1635 (5 mins.)
 */
public class SelectionSort {

    public static int[] sort(int[] elements) {

        if (elements == null) return null;

        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[i]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
        return elements;
    }

    private static void print(int[] elements) {

        System.out.print("{");
        for (int i = 0; i < elements.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(elements[i]);
        }
        System.out.println("}");
    }

    public static void main(String[] args) {

        int[] elements = { 1, 3, 2, 1, 9, 7, 0, 5, 3, 8, 6, 4, 3 };
        print(elements);
        sort(elements);
        print(elements);
    }
}
