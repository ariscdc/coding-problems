package com.ariscdc.coding.ds.tree;

import java.lang.reflect.Array;

/**
 * @author ariscdc
 *
 * Heapify - Place a single element in the wrong position and then
 * find the right position for the element. Supported by two methods - siftUp() and siftDown().
 *
 * Time Complexity:
 * - Insert - O(log N)
 * - Access to Top - O(1)
 * - Remove - O(log N)
 *
 * 20160225 1030-1035 (5 mins.)
 * 20160225 1040-1045 (5 mins.)
 * 20160225 1130-1245 (75 mins.)
 * 20160225 1630-1715 (45 mins.)
 *                    (130 mins.)
 */
public class BinaryHeap<T extends Comparable> {

    enum Type { MAX_HEAP, MIN_HEAP }

    private T[] items;
    private int count;
    private Type type;

    @SuppressWarnings("all")
    protected BinaryHeap(Class<T> clazz, int maxSize, Type type) {
        this.items = (T[]) Array.newInstance(clazz, maxSize);
        this.type = type;
    }

    public void insert(T item) {

        if (isFull()) {
            throw new IllegalStateException("Heap is already full.");
        }
        items[count] = item;
        siftUp(count);
        count++;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public T getTopPriority() {
        return count > 0 ? items[0] : null;
    }

    public T removeTopPriority() {

        if (isEmpty()) return null;

        T top = items[0];
        items[0] = items[count - 1];
        count--;
        siftDown(0);

        return top;
    }

    public int size() {
        return count;
    }

    private int getLeftIndex(int index) {
        int leftIndex = (2 * index) + 1;
        return leftIndex < count ? leftIndex : -1;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getRightIndex(int index) {
        int leftIndex = (2 * index) + 2;
        return leftIndex < count ? leftIndex : -1;
    }

    @SuppressWarnings("unchecked")
    private boolean shouldSiftDown(int index, int otherIndex) {
        return type.equals(Type.MAX_HEAP)
                ? items[index].compareTo(items[otherIndex]) > 0
                : items[index].compareTo(items[otherIndex]) < 0;
    }

    @SuppressWarnings("unchecked")
    private boolean shouldSiftUp(int index, int parentIndex) {
        return type.equals(Type.MAX_HEAP)
                ? items[index].compareTo(items[parentIndex]) >= 0
                : items[index].compareTo(items[parentIndex]) <= 0;
    }

    private void siftUp(int index) {

        if (index == 0) return;
        int parentIndex = getParentIndex(index);

        if (shouldSiftUp(index, parentIndex)) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDown(int index) {

        int leftIndex = getLeftIndex(index);
        int rightIndex = getRightIndex(index);
        int siftIndex = -1;

        if (leftIndex != -1 && rightIndex != -1) {
            siftIndex = shouldSiftDown(leftIndex, rightIndex) ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            siftIndex = leftIndex;
        } else if (rightIndex != -1) {
            siftIndex = rightIndex;
        }

        if (siftIndex == -1) return;

        if (shouldSiftDown(siftIndex, index)) {
            swap(siftIndex, index);
            siftDown(siftIndex);
        }
    }

    private void swap(int index1, int index2) {

        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public static void main(String[] args) {

        //  Min Heap:           Max Heap:
        //
        //          5                  17
        //        /   \              /    \
        //       7     9            16     12
        //     /  \   /  \         /  \   /  \
        //    10  10 16  12       10   7 10   9
        //   /                   /
        //  17                  5
        //
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer.class, 1000, Type.MAX_HEAP);

        heap.insert(10);
        heap.insert(7);
        heap.insert(12);
        heap.insert(5);
        heap.insert(10);
        heap.insert(16);
        heap.insert(9);
        heap.insert(17);

        for (int i = 0; i < 992; i++) {
            heap.insert((int) Math.round(Math.random() * 1000));
        }
        while (!heap.isEmpty()) {
            System.out.println(heap.removeTopPriority());
        }
    }
}
