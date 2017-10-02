package com.ariscdc.coding.problem.recursion;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * The number of subsets for a given set is 2^k, where k is the number of elements in the set.
 * Example:
 * {}      -> 2^1 -> 1 -> {}
 * {1}     -> 2^2 -> 2 -> {}, {1}
 * {1,2}   -> 2^3 -> 4 -> {}, {1}, {2}, {1,2}
 * {1,2,3} -> 2^4 -> 8 -> {}, {1}, {2}, {1,2}, {3}, {1, 3}, {2,3}, {1,2,3}
 *
 * Time Complexity: O(2^n)
 * Since we have to identify each subset, this complexity can no longer be reduced.
 *
 * 20160210 1705-1755 (50 mins.)
 */
public class GenerateAllSubsets {

    public static List<Set<Integer>> getSubsets(Integer[] set, int index) {

        List<Set<Integer>> newSubsets = new LinkedList<>();
        if (index < 0) {
            newSubsets.add(new LinkedHashSet<>());
            return newSubsets;
        }

        List<Set<Integer>> subsets = getSubsets(set, index - 1);

        for (Set<Integer> subset: subsets) {
            Set<Integer> newSubset = new LinkedHashSet<>();
            for (Integer element: subset) {
                newSubset.add(element);
            }
            newSubset.add(set[index]);
            newSubsets.add(newSubset);
        }

        subsets.addAll(newSubsets);
        return subsets;
    }

    public static void main(String[] args) {

        Integer[] set = { 1, 2, 3, 4 };
        List<Set<Integer>> subsets = getSubsets(set, set.length - 1);

        System.out.println("Number of Subsets: " + subsets.size());
        System.out.println("Subsets:");
        System.out.println(subsets);
    }
}
