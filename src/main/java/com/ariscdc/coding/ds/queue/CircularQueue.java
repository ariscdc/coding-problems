package com.ariscdc.coding.ds.queue;

import java.lang.reflect.Array;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Time Complexity: O(1) for all methods
 * Space Complexity: O(n)
 *
 * 20160306 1410-1430 (20 mins.)
 * 20160306 1520-1540 (20 mins.)
 * 20160306 1555-1650 (55 mins.)
 *                    (95 mins.)
 */
public class CircularQueue<T> implements Queue<T> {

    private int head = -1;
    private int tail = -1;
    private int size = 0;

    private T[] items;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public CircularQueue(Class<T> clazz, int maxSize) {
        items = (T[]) Array.newInstance(clazz, maxSize);
        this.maxSize = maxSize;
    }

    @Override
    public void enqueue(T item)
    throws QueueFullException {

        int nextIndex = getNextIndex(tail);
        if (nextIndex == head) {
            throw new QueueFullException();
        }
        items[nextIndex] = item;
        tail = nextIndex;
        if (head == -1) {
            head = tail;
        }
        size++;
    }

    @Override
    public T dequeue()
    throws QueueEmptyException {

        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T value = items[head];
        head = head == tail ? -1 : getNextIndex(head);
        size--;
        return value;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : items[head];
    }

    @Override
    public boolean isEmpty() {
        return head == -1;
    }

    @Override
    public boolean isFull() {
        int nextIndex = getNextIndex(tail);
        return nextIndex == head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(getClass().getSimpleName());

        int iterator = head;
        builder.append("[");

        if (!isEmpty()) {
            while (iterator != tail) {
                builder.append(items[iterator]);
                builder.append(",");
                iterator = getNextIndex(iterator);
            }
            builder.append(items[iterator]);
        }
        builder.append("]");
        return builder.toString();
    }

    private int getNextIndex(int index) {
        return (index + 1) % maxSize;
    }

    public static void main(String[] args)
    throws Exception {

        CircularQueue<Integer> queue = new CircularQueue<>(Integer.class, 5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);

        queue.enqueue(60);
        queue.enqueue(70);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
