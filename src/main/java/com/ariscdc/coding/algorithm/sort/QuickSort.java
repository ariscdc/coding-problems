package com.ariscdc.coding.algorithm.sort;

/**
 * @author ariscdc
 *
 * 6. Quick Sort
 *
 * Uses Divide and Conquer to create smaller problems which are easier to tackle.
 * The Partition is based on a Pivot, which is an element from the list.
 * List is partitioned with all elements smaller than the Pivot on one side and
 * larger than the Pivot on the other.
 * This Pivot partition is applied to all sub-lists till the list is sorted.
 *
 * Time Complexity: O(N log N) on Average case.
 * Space Complexity: O(log N) for the recursion call stack. Worst case could be O(N)
 * Not Stable, entities which are equal are NOT maintained in original order.
 * Not Adaptive, goes into recursive call and cannot see the big picture if the list is already sorted.
 *
 * 20160209 1550-1620 (30 mins.)
 * 20160209 1800-1900 (60 mins.)
 *                    (90 mins.)
 */
public class QuickSort {

    public static void sort(int[] elements, int start, int end, int step) {

        if (start >= end) return;

        int pivot = partition(elements, start, end, step);
        if (pivot > start) {
            sort(elements, start, pivot - 1, step);
        }
        if (end > pivot) {
            sort(elements, pivot + 1, end, step + 1);
        }
    }

    private static int partition(int[] elements, int start, int end, int step) {

        int pivot = elements[start];
        int startIndex = start;
        int endIndex = end;

        while (startIndex < endIndex) {
            while (elements[startIndex] < pivot) {
                startIndex++;
            }
            while (elements[endIndex] > pivot) {
                endIndex--;
            }
            swapElements(elements, startIndex, endIndex, step);
        }
        return endIndex;
    }

    private static void print(int[] elements, int start) {

        System.out.printf("%03d: {", start);
        for (int i = 0; i < elements.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(elements[i]);
        }
        System.out.println("}");
    }

    private static void swapElements(int[] elements, int i, int j, int step) {

        if (i == j) return;
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        print(elements, step);
    }

    public static void main(String[] args) {

//        int[] elements = { 1, 3, 2, 1, 9, 7, 0, 5, 3, 8, 6, 4, 3 };
//        int[] elements = { 1, 3, 2, 4, 9, 7, 8, 5, 6, 10 };
//        int[] elements = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] elements = { 3, 6, 4, 2, 9, 8 };
//        int[] elements = { 8, 2 };

        print(elements, 0);
        sort(elements, 0, elements.length - 1, 1);
    }
}
