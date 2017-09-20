package com.ariscdc.coding.algorithm.search;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Choose an element at the mid-point of a Sorted List.
 * Check whether it's less than or greater than the element.
 * If the element at the mid-point is larger, then search only the lower half.
 * By halving the search area at every step, Binary Search works much faster
 * than Linear Search.
 *
 * Time Complexity: O(log N)
 *
 * 20160210 1155-1220 (25 mins.)
 */
public class RecursiveBinarySearch {

    public static int search(int[] elements, int element, int start, int end) {

        if (start >= end) return -1;

        int mid = ((end - start) / 2) + start;
        if (element == elements[mid]) {
            return mid;
        }
        if (element > elements[mid]) {
            return search(elements, element, mid + 1, end);
        } else {
            return search(elements, element, start, mid);
        }
    }

    public static void main(String[] args) {

        int[] elements = { 11, 22, 33, 44, 55, 66, 77 };
        int element = 55;
        if (elements != null && elements.length > 0) {
            int index = search(elements, element, 0, elements.length);
            if (index == -1) {
                System.out.println("Element " + element + " not found.");
            } else {
                System.out.println("Element " + element + " is at index " + index + ".");
            }
        }
    }
}
