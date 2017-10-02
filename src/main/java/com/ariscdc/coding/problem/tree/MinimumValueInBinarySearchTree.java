package com.ariscdc.coding.problem.tree;

import com.ariscdc.coding.ds.tree.BinarySearchTree;
import com.ariscdc.coding.ds.tree.Node;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Find the minimum value in a Binary Search Tree.
 *
 * 20160216 1950-2000 (10 mins.)
 */
public class MinimumValueInBinarySearchTree {

    public static Integer iterativeFindMinimumValue(BinarySearchTree bst) {

        if (bst == null || bst.getRoot() == null) {
            return null;
        }
        Node<Integer> node = bst.getRoot();
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node.getData();
    }

    public static Integer recursiveFindMinimumValue(BinarySearchTree bst) {
        if (bst == null || bst.getRoot() == null) {
            return null;
        }
        return recursiveFindMinimumValue(bst.getRoot());
    }

    private static Integer recursiveFindMinimumValue(Node<Integer> node) {
        return node.getLeftChild() == null
                ? node.getData()
                : recursiveFindMinimumValue(node.getLeftChild());
    }

    public static void main(String[] args) {

        //
        //       10
        //      /  \
        //     5    20
        //    / \     \
        //   1   8     50
        //             /
        //           30
        //
        // 10 -> 5 -> 1 -> 8 -> 20 -> 50 -> 30

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(new Node<>(10));
        bst.insert(new Node<>(5));
        bst.insert(new Node<>(20));
        bst.insert(new Node<>(1));
        bst.insert(new Node<>(8));
        bst.insert(new Node<>(50));
        bst.insert(new Node<>(30));

        bst.printTree();

        System.out.println("Minimum Value: " + iterativeFindMinimumValue(bst));
        System.out.println("Minimum Value: " + recursiveFindMinimumValue(bst));
    }
}
