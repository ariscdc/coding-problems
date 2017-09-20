package com.ariscdc.coding.ds.stack;

/**
 * @author ariscdc
 *
 * 20160306 1325-1330 (5 mins.)
 */
public interface Stack<T> {

    void push(T item) throws StackFullException;
    T pop() throws StackEmptyException;
    T peek() throws StackEmptyException;

    boolean isEmpty();
    boolean isFull();
    int size();
}
