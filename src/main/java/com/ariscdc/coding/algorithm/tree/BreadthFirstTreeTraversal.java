package com.ariscdc.coding.algorithm.tree;

import com.ariscdc.coding.ds.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160216 1505-1515 (10 mins.)
 */
public class BreadthFirstTreeTraversal {

    public static <T> void traverse(Node<T> rootNode) {

        if (rootNode == null) return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            process(node);
            if (node.getLeftChild() != null) queue.add(node.getLeftChild());
            if (node.getRightChild() != null) queue.add(node.getRightChild());
        }
    }

    private static <T> void process(Node<T> node) {
        System.out.println(node.getData());
    }

    public static void main(String[] args) {

        //
        //       1
        //      / \
        //     2   3
        //    /   / \
        //   4   5   6
        //  / \
        // 7   8
        //
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        node1.setLeftChild(node2);
        node1.setRightChild(node3);

        node2.setLeftChild(node4);

        node3.setLeftChild(new Node<>(5));
        node3.setRightChild(new Node<>(6));

        node4.setLeftChild(new Node<>(7));
        node4.setRightChild(new Node<>(8));

        traverse(node1);
    }
}
