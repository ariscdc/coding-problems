package com.ariscdc.coding.algorithm.tree;

import com.ariscdc.coding.ds.tree.Node;

/**
 * @author ariscdc
 *
 * 20160216 1630-1635 (5)
 */
public class DepthFirstInOrderTreeTraversal {

    public static <T> void traverse(Node<T> rootNode) {

        if (rootNode == null) return;

        traverse(rootNode.getLeftChild());
        process(rootNode);
        traverse(rootNode.getRightChild());
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
        // 7 -> 4 -> 8 -> 2 -> 1 -> 5 -> 3 -> 6

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
