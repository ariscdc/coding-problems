package com.ariscdc.coding.problem.tree;

import com.ariscdc.coding.ds.tree.Node;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160216 2035-2105 (30)
 */
public class MirrorBinaryTree {

    public static Node<Integer> mirror(Node<Integer> node) {

        if (node == null) return null;

        Node<Integer> mirror = new Node<>(node.getData());

        if (node.getLeftChild() != null) {
            mirror.setRightChild(mirror(node.getLeftChild()));
        }
        if (node.getRightChild() != null) {
            mirror.setLeftChild(mirror(node.getRightChild()));
        }
        return mirror;
    }

    private static <T> void process(Node<T> node) {
        System.out.print(" -> " + node.getData());
    }

    private static <T> void traverse(Node<T> rootNode) {

        if (rootNode == null) return;

        process(rootNode);
        traverse(rootNode.getLeftChild());
        traverse(rootNode.getRightChild());
    }

    public static void main(String[] args) {

        // Source:
        //
        //       1
        //      / \
        //     2   3
        //    /   / \
        //   4   5   6
        //  / \
        // 7   8
        //
        // Pre-Order: 1 -> 2 -> 4 -> 7 -> 8 -> 3 -> 5 -> 6

        // Mirror:
        //
        //       1
        //      / \
        //     3   2
        //    / \   \
        //   6   5   4
        //          / \
        //         8   7
        //
        // Pre-Order: 1 -> 3 -> 6 -> 5 -> 2 -> 4 -> 8 -> 7

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

        System.out.print("Source (Pre-Order)");
        traverse(node1);
        System.out.println();

        System.out.print("Mirror (Pre-Order)");
        traverse(mirror(node1));
        System.out.println();
    }
}
