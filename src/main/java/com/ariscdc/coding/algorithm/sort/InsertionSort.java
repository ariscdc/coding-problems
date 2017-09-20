package com.ariscdc.coding.algorithm.sort;

/**
 * @author ariscdc
 *
 * 3. Insertion Sort
 *
 * Start with a sorted sub-list of size 1.
 * Insert the next element into the sorted sub-list at the right position.
 * In the worst case, if the list is originally sorted in descending order, N elements
 * are checked and swapped for every selected element to get to the right position.
 * It has very low overhead and is traditionally the sort of choice when used with
 * faster algorithms which follow the divide and conquer approach.
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * Stable sort, entities which are equal are maintained in original order.
 * O(N^2) comparisons and O(N^2) swaps
 * Adaptive, able to know and break if list is already sorted.
 *
 * 20160207 1920-1955 (35 mins.)
 * 20160207 2140-2150 (10 mins.)
 *                    (45 mins.)
 */
public class InsertionSort {

    public static int[] sort(int[] elements) {

        if (elements == null || elements.length < 2) return elements;

        int swaps = 1;
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

        int[] elements = { 1, 3, 2, 1, 9, 7, 0, 5, 3, 8, 6, 4, 3 };
//        int[] elements = { 5, 4, 3, 2, 1 };
        print(elements, 0);
        sort(elements);
    }
}
