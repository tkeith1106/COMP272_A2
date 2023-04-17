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
                // cant have duplicates so return if there is a duplicate node
                if (data == focus.data) return;
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
}
