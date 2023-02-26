import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    // init class variables
    BTNode root;

    public void addNode(int data) {
        // create object of new node
        BTNode newNode = new BTNode(data);

        // if node is null then assign the value
        if (this.root == null) {
            this.root = newNode;
        }
        else {
            // init
            BTNode focus = this.root;
            BTNode parent;

            // assign values by traversing nodes
            while (true) {
                parent = focus;
                if (data < focus.data) {
                    focus = focus.childLeft;
                    if (focus == null) {
                        parent.childLeft = newNode;
                        return;
                    }
                }
                else {
                    focus = focus.childRight;
                    if (focus == null) {
                        parent.childRight = newNode;
                        return;
                    }
                }
            }
        }
    }

    // Find node with value
    public BTNode findNode(int val, BTNode node) {
        // get node based on value and the input node; generally the root of the BT
        if (node == null || node.data == val) {
            return node;
        }
        BTNode leftResult = findNode(val, node.childLeft);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(val, node.childRight);
    }

    // Preorder traversal using recursion
    public void preOrder(BTNode node, List<BTNode> list) {
        if (node != null) {
            list.add(node);
            preOrder(node.childLeft, list);
            preOrder(node.childRight, list);
        }
    }

    // just for visualization to prove order is correct will not write test case
    public void printPreOrder(BTNode node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            printPreOrder(node.childLeft);
            printPreOrder(node.childRight);
        }
    }

    // Preorder next node
    public BTNode preOrderNext(int data) {
        // get node that corresponds to data
        BTNode node = findNode(data, this.root);
        // init array list
        List<BTNode> list = new ArrayList<>();
        preOrder(this.root, list);
        // iterate through node list and return next node value
        int i = list.indexOf(node);
        if (i < list.size() - 1) {
            return list.get(i + 1);
        } else {
            return null;
        }
    }

    // Inorder traversal
    public void inOrder(BTNode node, List<BTNode> list) {
        if (node != null) {
            inOrder(node.childLeft, list);
            list.add(node);
            inOrder(node.childRight, list);
        }
    }

    // just for visualization to prove order is correct will not write test case
    public void printInOrder(BTNode node) {
        if (node != null) {
            printInOrder(node.childLeft);
            System.out.print(node.data + ", ");
            printInOrder(node.childRight);
        }
    }

    // Inorder next node
    public BTNode inOrderNext(int data) {
        // get node that corresponds to data
        BTNode node = findNode(data, this.root);
        List<BTNode> list = new ArrayList<>();
        inOrder(root, list);
        int i = list.indexOf(node);
        if (i < list.size() - 1) {
            return list.get(i + 1);
        } else {
            return null;
        }
    }


    // Postorder traversal
    public void postOrder(BTNode node, List<BTNode> list) {
        if (node != null) {
            postOrder(node.childLeft, list);
            postOrder(node.childRight, list);
            list.add(node);
        }
    }

    // just for visualization to prove order is correct will not write test case
    public void printPostOrder(BTNode node) {
        if (node != null) {
            printPostOrder(node.childLeft);
            printPostOrder(node.childRight);
            System.out.print(node.data + ", ");
        }
    }

    // Postorder next node
    public BTNode postOrderNext(int data) {
        // get node that corresponds to data
        BTNode node = findNode(data, this.root);
        List<BTNode> list = new ArrayList<>();
        postOrder(root, list);
        int i = list.indexOf(node);
        if (i < list.size() - 1) {
            return list.get(i + 1);
        } else {
            return null;
        }
    }

}
