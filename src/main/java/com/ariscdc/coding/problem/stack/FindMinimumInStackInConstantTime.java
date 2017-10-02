package com.ariscdc.coding.problem.stack;

import com.ariscdc.coding.ds.stack.Stack;
import com.ariscdc.coding.ds.stack.StackEmptyException;
import com.ariscdc.coding.ds.stack.StackFullException;
import com.ariscdc.coding.ds.stack.StackImpl;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Find the minimum element in a Stack in constant time at every point in time.
 *
 * Solution:
 * Keep track of the minimum element for each element pushed.
 * Two Stacks are kept, one to hold the actual elements and another to store the minimum at that point.
 *
 * Actual Stack    Min Stack
 * [     24     ]  [     11     ]
 * [     11     ]  [     11     ]
 * [     30     ]  [     12     ]
 * [     12     ]  [     12     ]
 * [     46     ]  [     46     ]
 *
 * 20160306 1925-1955 (30 mins.)
 */
public class FindMinimumInStackInConstantTime {

    public static class MinStack<T extends Comparable> extends StackImpl<T> {

        private Stack<T> minStack = new StackImpl<>();

        @Override
        @SuppressWarnings("all")
        public void push(T item) throws StackFullException {

            T minItem = item;
            if (!minStack.isEmpty()) {
                try {
                    T minStackItem = minStack.peek();
                    if (minStackItem.compareTo(item) < 0) {
                        minItem = minStackItem;
                    }
                } catch (StackEmptyException e) {
                    throw new IllegalStateException(e);
                }
            }
            super.push(item);
            minStack.push(minItem);
        }

        @Override
        public T pop() throws StackEmptyException {

            T item = super.pop();
            minStack.pop();
            return item;
        }

        @Override
        public T peek() throws StackEmptyException {
            return super.peek();
        }

        @Override
        public boolean isEmpty() {
            return super.isEmpty();
        }

        @Override
        public boolean isFull() {
            return super.isFull();
        }

        @Override
        public int size() {
            return super.size();
        }

        public T getMinimumElement()
        throws StackEmptyException {
            try {
                return minStack.peek();
            } catch (StackEmptyException e) {
                throw new StackEmptyException("Stack is empty.");
            }
        }
    }

    public static void main(String[] args)
    throws Exception {

        MinStack<Integer> minStack = new MinStack<>();

        minStack.push(46);
        System.out.println(minStack);
        System.out.println("minimum = " + minStack.getMinimumElement());

        minStack.push(12);
        System.out.println(minStack);
        System.out.println("minimum = " + minStack.getMinimumElement());

        minStack.push(30);
        System.out.println(minStack);
        System.out.println("minimum = " + minStack.getMinimumElement());

        minStack.push(11);
        System.out.println(minStack);
        System.out.println("minimum = " + minStack.getMinimumElement());

        minStack.push(24);
        System.out.println(minStack);
        System.out.println("minimum = " + minStack.getMinimumElement());

        minStack.pop();
        System.out.println(minStack);
        System.out.println("minimum = " + minStack.getMinimumElement());

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack);

        try {
            System.out.println("minimum = " + minStack.getMinimumElement());
        } catch (StackEmptyException e) {
            System.out.println(e);
        }
    }
}
