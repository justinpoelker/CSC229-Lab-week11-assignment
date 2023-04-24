package com.mycompany.csc229_bst_example;

/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {

        // ToDo 1: complete InOrder Traversal 
        //Check if node is null
        if (root == null) {
            return;
        }
        //Call doInOrder method to the left of the root
        doInOrder(root.getLeft());
        //Print the data of the root
        System.out.print(root.getData() + " ");
        //calls doinorder method for the right of the root
        doInOrder(root.getRight());
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal . 
    }

    private void doPreOrder(BstNode root) {
        //Check if node is null
        if (root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        //Call dopreorder for left and right of the node root, 
        //crawls through all nodes.
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {

        // ToDo 3: Find the height of a tree
        return getHeight(this.root);
    }

    private Integer getHeight(BstNode root) {
        //Check if node is null
        if (root == null) {
            return -1;
        }

        //call left and right and store the node variables
        Integer leftHeight = getHeight(root.getLeft());
        Integer rightHeight = getHeight(root.getRight());
        //Return left and right heights and add one to the tree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node 

        //Check if node is null
        if (node == null) {
            return -1;
        }

        //Call the getdepth for left and right node locations
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        //return the max depth between the right and depth node locations and add 1
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        //Check of the node is null
        if (node != null) {
            //Print prefix and node
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.data);
            //Print left
            print(prefix + (isLeft ? "|   " : "    "), node.left, true);
            //Print right
            print(prefix + (isLeft ? "|   " : "    "), node.right, false);
        }
    }

}
