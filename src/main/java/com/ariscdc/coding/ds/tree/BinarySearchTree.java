package com.ariscdc.coding.ds.tree;

/**
 * @author ariscdc
 *
 * Time Complexity for Insertion and Lookup:
 *
 * Actual complexity depends on the shape of the tree.
 * O(log N) - In the average case for a somewhat balanced tree.
 * O(N) - If tree is skewed (with all left or right children only).
 *
 * For both operations, the tree to traverse is halved at every step making it log N complexity.
 *
 * 20160216 1710-1725 (15 mins.) - insert()
 * 20160216 1735-1805 (30 mins.) - get()
 *                    (45 mins.)
 */
public class BinarySearchTree {

    private Node<Integer> root;

    public Node<Integer> getRoot() {
        return root;
    }

    public Node<Integer> get(int value) {
        if (root == null) return null;
        return get(root, value);
    }

    public void insert(Node<Integer> newNode) {

        if (newNode == null) return;
        if (root == null) {
            root = newNode;
            return;
        }
        insert(root, newNode);
    }

    public void printTree() {

        System.out.print("Pre-Order Traversal");
        printTree(root);
        System.out.println();
    }

    private Node<Integer> get(Node<Integer> node, int value) {

        if (node == null) return null;
        if (value == node.getData()) return node;

        if (value < node.getData()) {
            return get(node.getLeftChild(), value);
        } else {
            return get(node.getRightChild(), value);
        }
    }

    private void insert(Node<Integer> node, Node<Integer> newNode) {

        if (newNode.getData() <= node.getData()) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(newNode);
            } else {
                insert(node.getLeftChild(), newNode);
            }
        } else {
            if (node.getRightChild() == null) {
                node.setRightChild(newNode);
            } else {
                insert(node.getRightChild(), newNode);
            }
        }
    }

    private void printTree(Node<Integer> node) {

        if (node == null) return;
        System.out.print(" -> " + node.getData());
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }

    public static void main(String[] args) {

        //
        //       2
        //      / \
        //     1   3
        //          \
        //           10
        //           / \
        //          4   20
        //
        // 2 -> 1 -> 3 -> 10 -> 4 -> 20

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(new Node<>(2));
        bst.insert(new Node<>(1));
        bst.insert(new Node<>(3));
        bst.insert(new Node<>(10));
        bst.insert(new Node<>(4));
        bst.insert(new Node<>(20));

        bst.printTree();

        System.out.println(bst.get(20));
        System.out.println(bst.get(30));
    }
}
