public class PPIBinaryTree extends BinaryTree {
    // field to store pre-order number
    private int preOrderNumberCount;
    // field to store post-order number
    private int postOrderNumberCount;
    // field to store in-order number
    private int inOrderNumberCount;

    // constructor
    PPIBinaryTree() {
        super();
        this.preOrderNumberCount = this.postOrderNumberCount = this.inOrderNumberCount = 0;
    }

    // method to assign pre-order numbers
    public void preOrderNumber() {
        preOrderNumber(this.root);
    }

    // helper method for assigning pre-order numbers
    private void preOrderNumber(BTNode node) {
        if (node != null) {
            node.preOrderNumber = this.preOrderNumberCount;
            this.preOrderNumberCount++;
            preOrderNumber(node.childLeft);
            preOrderNumber(node.childRight);
        }
    }

    // method to assign in-order numbers
    public void inOrderNumber() {
        inOrderNumber(this.root);
    }

    // helper method for assigning in-order numbers
    private void inOrderNumber(BTNode node) {
        if (node != null) {
            inOrderNumber(node.childLeft);
            node.inOrderNumber = this.inOrderNumberCount;
            this.inOrderNumberCount++;
            inOrderNumber(node.childRight);
        }
    }

    // method to assign post-order numbers
    public void postOrderNumber() {
        postOrderNumber(root);
    }

    // helper method for assigning post-order numbers
    private void postOrderNumber(BTNode node) {
        if (node != null) {
            postOrderNumber(node.childLeft);
            postOrderNumber(node.childRight);
            node.postOrderNumber = this.postOrderNumberCount;
            this.postOrderNumberCount++;
        }
    }
}
