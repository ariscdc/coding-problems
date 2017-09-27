package com.ariscdc.coding.algorithm.sort;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 2. Bubble Sort
 *
 * For each iteration, every element is compared with its neighbor and swapped if they are not in order.
 * At the end of the first iteration, the smallest element is in the right position, and so on.
 * The interesting thing here is that not only are 1,2,3 in the right position - the entire list is sorted.
 * In the next iteration, if no swaps are done then it means that the list is completely sorted and can
 * break out of the loop early.
 * In the worst case (if the list is originally sorted in descending order), N elements are checked
 * and swapped for every selected element to get to the right position.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Stable sort, entities which are equal are maintained in original order.
 * O(n^2) comparisons and O(n^2) swaps.
 * Adaptive, able to know and break if list is already sorted.
 *
 * 20160207 1715-1740 (25 mins.)
 */
public class BubbleSort {

    public static int[] sort(int[] elements) {

        if (elements == null || elements.length < 2) return elements;

        for (int i = 0; i < elements.length; i++) {
            boolean swapped = false;
            for (int j = elements.length - 1; j > i; j--) {
                if (elements[j] < elements[j - 1]) {
                    swapElements(elements, j - 1, j);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return elements;
    }

    private static void swapElements(int[] elements, int i, int j) {

        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
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
