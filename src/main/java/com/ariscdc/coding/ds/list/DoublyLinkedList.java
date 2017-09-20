package com.ariscdc.coding.ds.list;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * <IN_PROGRESS>
 *
 * 20160306 1010-1015 (5 mins.)
 */
public class DoublyLinkedList {

    private static class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{value=" + value + "}";
        }
    }
}
