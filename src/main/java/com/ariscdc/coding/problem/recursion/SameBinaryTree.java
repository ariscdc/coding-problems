package com.ariscdc.coding.problem.recursion;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Time Complexity: O(n), we have to visit every node in the Binary Tree.
 *
 * 20160210 2310-2350 (40 mins.)
 */
public class SameBinaryTree {

    public static boolean isSameBinaryTree(BinaryTree tree1, BinaryTree tree2) {

        if (tree1 == null && tree2 == null) return true;
        return tree1 != null && tree2 != null
                && isSameBinaryTree(tree1.getRootNode(), tree2.getRootNode());
    }

    @SuppressWarnings("all")
    private static boolean isSameBinaryTree(BinaryTree.Node node1, BinaryTree.Node node2) {

        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null) return false;
        if (node1 != null && node2 == null) return false;
        if (node1.getValue() != node2.getValue()) return false;

        return isSameBinaryTree(node1.getLeft(), node2.getLeft())
                && isSameBinaryTree(node1.getRight(), node2.getRight());
    }

    private static class BinaryTree {

        private Node rootNode;

        BinaryTree(Node rootNode) {
            this.rootNode = rootNode;
        }

        public Node getRootNode() {
            return rootNode;
        }

        private static class Node {

            private int value;
            private Node left;
            private Node right;

            Node(int value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }

            public int getValue() {
                return value;
            }
            public Node getLeft() {
                return left;
            }
            public Node getRight() {
                return right;
            }

            @Override
            public String toString() {
                return "Vertex{value=" + value + "}";
            }
        }
    }

    public static void main(String[] args) {

        //  Tree 1     Tree 2     Tree 3
        //     1          1          1
        //   /   \      /   \      /   \
        //  2     3    2     3    2     4

        BinaryTree.Node tree1level1Left = new BinaryTree.Node(2, null, null);
        BinaryTree.Node tree1level1Right = new BinaryTree.Node(3, null, null);
        BinaryTree.Node rootNode1 = new BinaryTree.Node(1, tree1level1Left, tree1level1Right);

        BinaryTree.Node tree2level1Left = new BinaryTree.Node(2, null, null);
        BinaryTree.Node tree2level1Right = new BinaryTree.Node(3, null, null);
        BinaryTree.Node rootNode2 = new BinaryTree.Node(1, tree2level1Left, tree2level1Right);

        BinaryTree.Node tree3level1Left = new BinaryTree.Node(2, null, null);
        BinaryTree.Node tree3level1Right = new BinaryTree.Node(4, null, null);
        BinaryTree.Node rootNode3 = new BinaryTree.Node(1, tree3level1Left, tree3level1Right);

        BinaryTree binaryTree1 = new BinaryTree(rootNode1);
        BinaryTree binaryTree2 = new BinaryTree(rootNode2);
        BinaryTree binaryTree3 = new BinaryTree(rootNode3);

        System.out.println("Tree 1 == Tree 2?");
        System.out.println(isSameBinaryTree(binaryTree1.getRootNode(), binaryTree2.getRootNode()));

        System.out.println();
        System.out.println("Tree 1 == Tree 3?");
        System.out.println(isSameBinaryTree(binaryTree1.getRootNode(), binaryTree3.getRootNode()));
    }
}
