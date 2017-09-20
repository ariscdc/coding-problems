package com.ariscdc.coding.ds.queue;

import com.ariscdc.coding.ds.stack.Stack;
import com.ariscdc.coding.ds.stack.StackEmptyException;
import com.ariscdc.coding.ds.stack.StackFullException;
import com.ariscdc.coding.ds.stack.StackImpl;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Time Complexity: O(n), where n is the number of operations performed.
 * Enqueues and dequeues are O(1), if only one of these operations is invoked.
 *
 * 20160313 1655-1720 (25 mins.)
 */
public class QueueUsingTwoStacks<T> implements Queue<T> {

    private Stack<T> forwardStack;
    private Stack<T> reverseStack;

    public QueueUsingTwoStacks(int maxSize) {

        forwardStack = new StackImpl<>(maxSize);
        reverseStack = new StackImpl<>(maxSize);
    }

    @Override
    public void enqueue(T item)
    throws QueueFullException {

        if (isFull()) {
            throw new QueueFullException();
        }
        try {
            transferToForwardStack();
            forwardStack.push(item);

        } catch (StackEmptyException | StackFullException e) {
            throw new QueueFullException();
        }
    }

    @Override
    public T dequeue()
    throws QueueEmptyException {

        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        try {
            transferToReverseStack();
            return reverseStack.pop();

        } catch (StackEmptyException | StackFullException e) {
            throw new QueueEmptyException();
        }
    }

    @Override
    public T peek()
    throws QueueEmptyException {

        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        try {
            transferToReverseStack();
            return reverseStack.peek();

        } catch (StackEmptyException | StackFullException e) {
            throw new QueueEmptyException();
        }
    }

    @Override
    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    @Override
    public int size() {
        return forwardStack.size() + reverseStack.size();
    }

    private void transferToForwardStack()
    throws StackEmptyException, StackFullException {
        if (forwardStack.isEmpty()) {
            while (!reverseStack.isEmpty()) {
                forwardStack.push(reverseStack.pop());
            }
        }
    }

    private void transferToReverseStack()
    throws StackEmptyException, StackFullException {
        if (reverseStack.isEmpty()) {
            while (!forwardStack.isEmpty()) {
                reverseStack.push(forwardStack.pop());
            }
        }
    }

    public static void main(String[] args)
    throws Exception {

        Queue<Integer> queue = new QueueUsingTwoStacks<>(3);
        System.out.println("queue.isEmpty() = " + queue.isEmpty());

        System.out.println("queue.push() -> 10");
        queue.enqueue(10);

        System.out.println("queue.push() -> 20");
        queue.enqueue(20);

        System.out.println("queue.push() -> 30");
        queue.enqueue(30);

        System.out.println("queue.isEmpty() = " + queue.isEmpty());
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.size() = " + queue.size());

        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.size() = " + queue.size());

        System.out.println("queue.push() -> 40");
        queue.enqueue(40);

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.size() = " + queue.size());

        System.out.println();
    }
}
