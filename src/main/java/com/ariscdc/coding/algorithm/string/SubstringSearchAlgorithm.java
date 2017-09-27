package com.ariscdc.coding.algorithm.string;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160228 1350-1355 (5 mins.)
 */
public abstract class SubstringSearchAlgorithm {

    public abstract int search(String source, String pattern);

    public int searchIgnoreCase(String source, String pattern) {
        return search(source.toLowerCase(), pattern.toLowerCase());
    }
}
