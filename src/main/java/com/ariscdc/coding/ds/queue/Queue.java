package com.ariscdc.coding.ds.queue;

/**
 * @author ariscdc
 *
 * 20160306 1400-1405 (5 mins.)
 */
public interface Queue<T> {

    void enqueue(T item) throws QueueFullException;
    T dequeue() throws QueueEmptyException;
    T peek() throws QueueEmptyException;

    boolean isEmpty();
    boolean isFull();
    int size();
}
