package com.ariscdc.coding.algorithm.search;

/**
 * @author ariscdc
 *
 * Choose an element at the mid-point of a Sorted List.
 * Check whether it's less than or greater than the element.
 * If the element at the mid-point is larger, then search only the lower half.
 * By halving the search area at every step, Binary Search works much faster
 * than Linear Search.
 *
 * Time Complexity: O(log N)
 *
 * 20160210 1535-1550 (15 mins.)
 */
public class IterativeBinarySearch {

    public static int search(int[] elements, int element) {

        int start = 0;
        int end = elements.length;

        while (start < end) {
            int mid = ((end - start) / 2) + start;
            if (element == elements[mid]) {
                return mid;
            } else if (element > elements[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] elements = { 11, 22, 33, 44, 55, 66, 77 };
        int element = 55;
        if (elements != null && elements.length > 0) {
            int index = search(elements, element);
            if (index == -1) {
                System.out.println("Element " + element + " not found.");
            } else {
                System.out.println("Element " + element + " is at index " + index + ".");
            }
        }
    }
}
