public class BTNode {
    // init class variables
    int data;
    BTNode childLeft, childRight;
    // field to store pre-order number
    public int preOrderNumber;
    // field to store post-order number
    public int postOrderNumber;
    // field to store in-order number
    public int inOrderNumber;

    // default constructor
    public BTNode(int item) {
        this.data = item;
        childLeft = childRight =null;
    }

}
