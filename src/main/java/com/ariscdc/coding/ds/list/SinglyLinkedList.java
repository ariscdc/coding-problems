package com.ariscdc.coding.ds.list;

/**
 * @author ariscdc
 *
 * Singly Linked List implementation without using Sentinels.
 *
 * Sentinels are placeholder elements placed at the end of the list to remove
 * explicit checking of head or tail elements. Head will always point to Head Sentinel.
 *
 * An empty list:
 * SinglyLinkedList -> Head Sentinel -> null.
 *
 * A list with items:
 * SinglyLinkedList -> Head Sentinel -> item 1 -> item 2 -> item 3 -> null.
 *
 * 20160306 0925-0930 (5 mins.)
 * 20160306 0950-1010 (20 mins.)
 * 20160306 1015-1205 (110 mins.)
 *                    (135 mins.)
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public void add(T item) {

        if (head != null) {
            Node<T> iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(new Node<>(item));
        } else {
            head = new Node<>(item);
        }
        size++;
    }

    public void add(int index, T item) {

        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> nodeBefore = getNodeBefore(index);
            newNode.setNext(nodeBefore.getNext());
            nodeBefore.setNext(newNode);
        }
        size++;
    }

    public T get(int index) {

        if (head == null) return null;
        if (index == 0) return head.getValue();

        return getNodeBefore(index).getNext().getValue();
    }

    public T remove(int index) {

        if (head == null) return null;
        if (index == 0) return removeFromHead();

        T value;
        Node<T> nodeBefore = getNodeBefore(index);
        Node<T> nodeAtIndex = nodeBefore.getNext();
        nodeBefore.setNext(nodeAtIndex.getNext());

        value = nodeAtIndex.getValue();
        size--;

        return value;
    }

    public T removeFromHead() {

        if (head == null) return null;

        Node<T> top = head;
        head = head.getNext();
        size--;

        return top.getValue();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        Node<T> iterator = head;

        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append("[");

        while (iterator != null) {
            builder.append(iterator.getValue());
            if (iterator.getNext() != null) {
                builder.append(",");
            }
            iterator = iterator.getNext();
        }
        builder.append("]");

        return builder.toString();
    }

    private Node<T> getNodeBefore(int index) {

        if (index > size - 1) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        int count = 0;
        Node<T> iterator = head;
        while (count < index - 1) {
            iterator = iterator.getNext();
            count++;
        }
        return iterator;
    }

    private static class Node<T> {

        private T value;
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

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        {
            // head -> 6 -> 9 -> 12 -> 3 -> null
            list.add(0, 3);
            list.add(0, 6);
            list.add(1, 9);
            list.add(2, 12);

            int size = list.size();
            System.out.println("size = " + size);

            System.out.println("Get value at index 0 = " + list.get(0));
            System.out.println("Get value at index 1 = " + list.get(1));
            System.out.println("Get value at index 2 = " + list.get(2));
            System.out.println("Get value at index 3 = " + list.get(3));

            for (int i = 0; i < size; i++) {
                System.out.println("Remove value from head = " + list.removeFromHead());
            }
            System.out.println("size = " + list.size());
            System.out.println("Remove value from head = " + list.removeFromHead());
        }

        System.out.println();
        {
            // head -> 6 -> 9 -> 12 -> 3 -> null
            list.add(0, 3);
            list.add(0, 6);
            list.add(1, 9);
            list.add(2, 12);

            System.out.println(list);
            System.out.println("Remove value at index 3 = " + list.remove(3));
            System.out.println(list);
            System.out.println("Remove value at index 1 = " + list.remove(1));
            System.out.println(list);
            System.out.println("Remove value at index 0 = " + list.remove(0));
            System.out.println(list);
        }
    }
}
