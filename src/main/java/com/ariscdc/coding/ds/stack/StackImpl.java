package com.ariscdc.coding.ds.stack;

import com.ariscdc.coding.ds.list.SinglyLinkedList;

/**
 * @author ariscdc
 *
 * Time Complexity: O(1) for all methods.
 * Space Complexity: O(N)
 *
 * 20160306 0905-0910 (5 mins.)
 * 20160306 1330-1400 (30 mins.)
 *                    (35 mins.)
 */
public class StackImpl<T> implements Stack<T> {

    private int maxSize;
    private SinglyLinkedList<T> items = new SinglyLinkedList<>();

    public StackImpl() {
        this.maxSize = Integer.MAX_VALUE;
    }

    public StackImpl(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(T item)
    throws StackFullException {

        if (items.size() == maxSize) throw new StackFullException("Cannot push on a full Stack.");
        items.add(0, item);
    }

    public T pop()
    throws StackEmptyException {

        if (items.size() == 0) throw new StackEmptyException("Cannot pop on an empty Stack.");
        return items.removeFromHead();
    }

    public T peek()
    throws StackEmptyException {
        if (items.size() == 0) throw new StackEmptyException("Cannot peek on an empty Stack.");
        return items.get(0);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public boolean isFull() {
        return items.size() == maxSize;
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName())
                .append("{top=[")
                .append(items)
                .append("]}")
                .toString();
    }

    public static void main(String[] args)
    throws Exception {

        StackImpl<Integer> stack = new StackImpl<>(3);

        System.out.println("isEmpty = " + stack.isEmpty());
        System.out.println("isFull = " + stack.isFull());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("peek = " + stack.peek());
        System.out.println("size = " + stack.size());
        System.out.println("isEmpty = " + stack.isEmpty());
        System.out.println("isFull = " + stack.isFull());

        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("size = " + stack.size());
        System.out.println("isEmpty = " + stack.isEmpty());
        System.out.println("isFull = " + stack.isFull());
    }
}
