package com.ariscdc.coding.problem.tree;

import com.ariscdc.coding.ds.tree.BinarySearchTree;
import com.ariscdc.coding.ds.tree.Node;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Determine the depth of a Binary Tree.
 *
 * 20160216 2020-2025 (5 mins.)
 */
public class DepthOfABinaryTree {

    public static int findDepth(BinarySearchTree bst) {

        if (bst == null || bst.getRoot() == null) return -1;
        return findDepth(bst.getRoot(), 0);
    }

    private static int findDepth(Node<Integer> node, int depth) {

        int left = depth;
        int right = depth;
        if (node.getLeftChild() != null) {
            left = findDepth(node.getLeftChild(), depth + 1);
        }
        if (node.getRightChild() != null) {
            right = findDepth(node.getRightChild(), depth + 1);
        }
        return Math.max(left, right);
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

        System.out.println("Depth: " + findDepth(bst));
    }
}
