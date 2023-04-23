/*
Name        : A2_Q2
Author      : Ty Keith | 3270281
Version     : 1.0
Created     : 2023-04-16
Description : Create a subclass of BinaryTree whose nodes have fields for storing preorder, post-order, and in-order
              numbers. Write methods preOrderNumber(), inOrderNumber(), and postOrderNumbers() that assign these numbers
              correctly. These methods should each run in O(n) time
*/

/*
    Underlying assumptions for implementation of assignment question:
        - Will only be implementing the methods asked for above as it is assumed any other methods are known via reading
        text and watching YouTube lectures and do not need to be shown, unless necessary to properly implement things.
        - any classes needed for the implementation will be in a class file with its corresponding name; ex. Node.java
        for node class
 */

public class Q5 {
    public static void main(String[] args) {
        // init main list the node value will consist of
        Integer[] list = {25, 15, 50, 10, 12, 4, 22, 18, 24, 70, 35, 31, 44, 66, 90};

        // init BT
        PPIBinaryTree tree = new PPIBinaryTree();

        // add node values
        for (int value : list) {
            tree.addNode(value);
        }

        // setup pre post and in order counts
        // TODO verify that these orders are correct??
        tree.preOrderNumber();
        tree.postOrderNumber();
        tree.inOrderNumber();

        System.out.println("List Values:\n");
        for (int value : list) {
            System.out.printf(
                    "List Value:\t%03d\tPre-Order:\t%03d\t|\tPost-Order:\t%03d\t|\tIn-Order:\t%03d",
                    tree.findNode(value, tree.root).data,
                    tree.findNode(value, tree.root).preOrderNumber,
                    tree.findNode(value, tree.root).postOrderNumber,
                    tree.findNode(value, tree.root).inOrderNumber
                    );
            System.out.println();
        }
    }
}