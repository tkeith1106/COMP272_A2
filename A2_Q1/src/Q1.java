/*
Name        : A2_Q1
Author      : Ty Keith | 3270281
Version     : 1.0
Created     : 2023-02-20
Description : Design an algorithm for the following operations for a binary tree BT, and show the worst-case running
              times for each implementation:
                    preorderNext(x): return the node visited after node x in a pre-order traversal of BT.
                    postorderNext(x): return the node visited after node x in a post-order traversal of BT.
                    inorderNext(x): return the node visited after node x in an in-order traversal of BT.
*/

/*
Underlying assumptions for implementation of assignment question:
    - Will only be implementing the methods asked for above as it is assumed any other methods are known via reading
    text and watching YouTube lectures and do not need to be shown, unless necessary to properly implement things.
    - any classes needed for the implementation will be in a class file with its corresponding name; ex. Node.java
    for node class
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Q1 {
    public static void main(String[] args) {

        // solutions for preOrderNext with timer
//        long startTime = System.nanoTime();
//        preOrderNextWorstCase();
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("\nRun Time: " + duration + "\n\n");
//
//        startTime = System.nanoTime();
//        preOrderNextBestCase();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime);
//        System.out.println("\nRun Time: " + duration + "\n\n");


        // solution for postOrderNext
        postOrderNextWorstCase();


    }

    public static void postOrderNextWorstCase() {
        BinaryTree tree = new BinaryTree();

        ArrayList<Integer> nodeList = new ArrayList<>();
        Random rando = new Random();

        for (int i=0; i<25; i++) {
            int value = rando.nextInt(1000);
            tree.addNode(value);
            nodeList.add(i, value);
        }

        tree.printPostOrder(tree.root);

        System.out.println("\n");

        for (int i: nodeList) {
            BTNode nextNode = tree.postOrderNext(i);
            if (nextNode != null) {
                System.out.printf("Data: %03d; Next: %03d\n", i, nextNode.data);
            }
            else {
                System.out.printf("Data: %03d; Next: None\n", i);
            }
        }

    }

    public static void preOrderNextWorstCase() {
        BinaryTree tree = new BinaryTree();

        ArrayList<Integer> nodeList = new ArrayList<>();
        Random rando = new Random();

        for (int i=0; i<25; i++) {
            int value = rando.nextInt(1000);
            tree.addNode(value);
            nodeList.add(i, value);
        }

        tree.printPreOrder(tree.root);

        System.out.println("\n");

        nodeList.sort(Collections.reverseOrder());
        for (int i: nodeList) {
            BTNode nextNode = tree.preOrderNext(i);
            if (nextNode != null) {
                System.out.printf("Data: %03d; Next: %03d\n", i, nextNode.data);
            }
            else {
                System.out.printf("Data: %03d; Next: None\n", i);
            }
        }
    }

    public static void preOrderNextBestCase() {
        BinaryTree tree = new BinaryTree();

        int[] nodeList = new int[25];

        for (int i=0; i<25; i++) {
            tree.addNode(i);
            nodeList[i] = i;
        }

        tree.printPreOrder(tree.root);

        System.out.println("\n");

        for (int i: nodeList) {
            BTNode nextNode = tree.preOrderNext(i);
            if (nextNode != null) {
                System.out.printf("Data: %03d; Next: %03d\n", i, nextNode.data);
            }
            else {
                System.out.printf("Data: %03d; Next: None\n", i);
            }
        }
    }
}