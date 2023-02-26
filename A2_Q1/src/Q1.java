/*
Name        : A2_Q1
Author      : Ty Keith | 3270281
Version     : 1.0
Created     : 2023-02-20
Description : Design an algorithm for the following operations for a binary tree BT, and show the worst-case running
              times for each implementation:
                    - preorderNext(x): return the node visited after node x in a pre-order traversal of BT.
                    - postorderNext(x): return the node visited after node x in a post-order traversal of BT.
                    - inorderNext(x): return the node visited after node x in an in-order traversal of BT.
*/

/*
    Underlying assumptions for implementation of assignment question:
        - Will only be implementing the methods asked for above as it is assumed any other methods are known via reading
        text and watching YouTube lectures and do not need to be shown, unless necessary to properly implement things.
        - any classes needed for the implementation will be in a class file with its corresponding name; ex. Node.java
        for node class
 */

public class Q1 {
    public static void main(String[] args) {

        // init main list the node value will consist of
        Integer[] list = {25, 15, 50, 10, 12, 4, 22, 18, 24, 70, 35, 31, 44, 66, 90};
        // init the method list that will drive the worst case for-loop
        String[] methodList = {"preorder", "inorder", "postorder"};

        // print out what the order of the original list is
        System.out.print("Original List: [");
        for (int value: list) {
            System.out.printf("%s, ", value);
        }
        System.out.print("]\n");

        // execute preOrderCase method
        printHeader("Pre-Order BT");
        preOrderCase(list);

        // execute inOrderCase method
        printHeader("In-Order BT");
        inOrderCase(list);

        // execute postOrderCase method
        printHeader("Post-Order BT");
        postOrderCase(list);

        /*
        print out info and execute the worst case run times for each traversal method. These are hardcoded as the reverse
        of each best case scenario.
        */

        printHeader("Testing Worst Cases Traversal");
        for (String item: methodList) {
            Integer[] worstCaseList = new Integer[]{};
            if (item.equalsIgnoreCase("preorder")) {
                worstCaseList = new Integer[]{90, 66, 44, 31, 24, 18, 12, 4, 70, 35, 22, 10, 50, 15, 25};
            }
            else if (item.equalsIgnoreCase("inorder")) {
                worstCaseList = new Integer[]{90, 70, 66, 50, 44, 35, 31, 25, 24, 22, 18, 15, 12, 10, 4};
            }
            else if (item.equalsIgnoreCase("postorder")) {
                worstCaseList = new Integer[]{25, 50, 70, 90, 66, 35, 44, 31, 15, 22, 24, 18, 10, 12, 4};
            }


            System.out.printf("Worst Case Run Time of %s: ", item);
            long start = System.nanoTime();
            worstCase(worstCaseList, item);
            System.out.printf("%d nanoseconds.\n", (System.nanoTime() - start));
        }
    }

    public static void preOrderCase(Integer[] list) {
        // init BT
        BinaryTree tree = new BinaryTree();

        // add node values
        for (int value : list) {
            tree.addNode(value);
        }

        // print out pre-order values
        System.out.print("[ ");
        tree.printPreOrder(tree.root);
        System.out.print("]\n\n");

        // get the next value for each node
        for (int value : list) {
            BTNode nextNode = tree.preOrderNext(value);
            if (nextNode != null) {
                System.out.printf("Data: %03d; Next: %03d\n", value, nextNode.data);
            } else {
                System.out.printf("Data: %03d; Next: None\n", value);
            }
        }
    }

    public static void inOrderCase(Integer[] list) {
        // init BT
        BinaryTree tree = new BinaryTree();

        // add node values
        for (int value : list) {
            tree.addNode(value);
        }

        // print out in-order values
        System.out.print("[ ");
        tree.printInOrder(tree.root);
        System.out.print("]\n");

        // get the next value for each node
        for (int value : list) {
            BTNode nextNode = tree.inOrderNext(value);
            if (nextNode != null) {
                System.out.printf("Data: %03d; Next: %03d\n", value, nextNode.data);
            } else {
                System.out.printf("Data: %03d; Next: None\n", value);
            }
        }

    }

    public static void postOrderCase(Integer[] list) {
        // init BT
        BinaryTree tree = new BinaryTree();

        // add node values
        for (int value : list) {
            tree.addNode(value);
        }

        // print out post-order values
        System.out.print("[ ");
        tree.printPostOrder(tree.root);
        System.out.print("]\n");

        // get the next value for each node
        for (int value : list) {
            BTNode nextNode = tree.postOrderNext(value);
            if (nextNode != null) {
                System.out.printf("Data: %03d; Next: %03d\n", value, nextNode.data);
            } else {
                System.out.printf("Data: %03d; Next: None\n", value);
            }
        }

    }

    public static void worstCase(Integer[] worstCaseList, String orderMethod) {
        // init the BT
        BinaryTree tree = new BinaryTree();

        // add node values
        for (int value : worstCaseList) {
            tree.addNode(value);
        }

        // get next node for each value; no assignment for this one due to testing purposes
        for (int value : worstCaseList) {
            if (orderMethod.equalsIgnoreCase("preorder")) {
                tree.postOrderNext(value);
            } else if (orderMethod.equalsIgnoreCase("inorder")) {
                tree.inOrderNext(value);
            } else if (orderMethod.equalsIgnoreCase("postorder")) {
                tree.postOrderNext(value);
            } else {break;}
        }

    }

    public static void printHeader(String caseName) {
        // print a standard header
        String middle = "#".repeat((((35-(caseName.length()))/2)));
        String header = "#".repeat(caseName.length() +(middle.length()*2)+2);
        System.out.printf("\n%s\n%s %s %s\n%s\n\n", header, middle, caseName, middle, header);
    }
}