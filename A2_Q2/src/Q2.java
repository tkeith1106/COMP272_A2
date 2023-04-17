/*
Name        : A2_Q2
Author      : Ty Keith | 3270281
Version     : 1.0
Created     : 2023-02-25
Description : Design a recursive linear-time algorithm that tests whether a binary tree satisfies the search tree order
              property at every node
*/

/*
    Underlying assumptions for implementation of assignment question:
        - Will only be implementing the methods asked for above as it is assumed any other methods are known via reading
        text and watching YouTube lectures and do not need to be shown, unless necessary to properly implement things.
        - any classes needed for the implementation will be in a class file with its corresponding name; ex. Node.java
        for node class
 */

import java.util.Random;

public class Q2 {
    public static void main(String[] args) {
        //init random
        Random random = new Random();

        // init main list the node value will consist of
        Integer[] list = new Integer[10];

        // fill list with random integers
        for (int i=0; i<10; i++) {
            list[i] = random.nextInt(251);
        }

        // print out what the order of the original list is
        System.out.print("Original List: [");
        for (int value: list) {
            System.out.printf("%s, ", value);
        }
        System.out.print("]\n");

        // init BT
        BinaryTree tree = new BinaryTree();

        // add node values
        for (int value : list) {
            tree.addNode(value);
        }

        printTree(tree.root, "|");

        boolean validBST = ValidateBST.isValidBST(tree.root);

        if (validBST) {
            System.out.println("Valid Binary Search Tree");
        }

        else {
            System.out.println("Invalid Binary Search Tree");
        }

    }

    public static void printTree(BTNode node, String prefix)
    {
        if(node == null) return;

        System.out.println(prefix + " --> " + node.data);
        printTree(node.childLeft , prefix + "     ");
        printTree(node.childRight , prefix + "     ");
    }
}