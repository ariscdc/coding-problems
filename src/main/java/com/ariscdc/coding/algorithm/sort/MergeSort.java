package com.ariscdc.coding.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 5. Merge Sort
 *
 * Follows the Divide and Conquer approach to create smaller sub-problems.
 * A list is broken down into smaller and smaller parts recursively wherein
 * at some point there will be a list of length one.
 * Merge the sorted lists together to get the fully sorted list.
 * Classic recursion based algorithm, divide till the problem is so small as to be trivial.
 * Solve for the trivial case and then build up the complete solution as the recursion unwinds.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * Stable, entities which are equal are maintained in original order.
 * Not Adaptive, goes into recursive call and cannot see the big picture if the list is already sorted.
 *
 * 20160209 1210-1250 (40 mins.)
 * 20160209 1430-1450 (20 mins.)
 *                    (60 mins.)
 */
public class MergeSort {

    public static List<Integer> sort(List<Integer> elements, int stepNum) {

        if (elements.size() == 1) return elements;
        int mid = elements.size() / 2;
        print(elements, stepNum);
        List<Integer> merged = merge(
                sort(elements.subList(0, mid), stepNum + 1),
                sort(elements.subList(mid, elements.size()), stepNum + 2)
        );
        print(merged, stepNum);
        return merged;
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {

        List<Integer> merged = new ArrayList<>(list1.size() + list2.size());

        int i1 = 0;
        int i2 = 0;
        int size = list1.size() + list2.size();

        while (merged.size() != size) {
            if (list1.get(i1) < list2.get(i2)) {
                merged.add(list1.get(i1));
                i1++;
                if (i1 == list1.size()) {
                    for (int i = i2; i < list2.size(); i++) {
                        merged.add(list2.get(i));
                    }
                }
            } else {
                merged.add(list2.get(i2));
                i2++;
                if (i2 == list2.size()) {
                    for (int i = i1; i < list1.size(); i++) {
                        merged.add(list1.get(i));
                    }
                }
            }
        }
        return merged;
    }

    private static void print(List<Integer> elements, int start) {

        System.out.printf("%03d: {", start);
        for (int i = 0; i < elements.size(); i++) {
            if (i > 0) System.out.print(",");
            System.out.print(elements.get(i));
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        {
            List<Integer> elements = Arrays.asList( 1, 3, 2, 1, 9, 7, 0, 5, 3, 8, 6, 4, 3 );
            print(elements, 0);
            sort(elements, 1);
        }
        System.out.println();
        {
            List<Integer> elements = Arrays.asList( 4, 3, 2, 1 );
            print(elements, 0);
            sort(elements, 1);
        }
    }
}
