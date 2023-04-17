import org.junit.jupiter.api.Test;

class BTValidationTest {
    // test empty tree
    @Test
    public void testIsValidBSTWithEmptyTree() {
        BinaryTree testTree = new BinaryTree();

        boolean result = ValidateBST.isValidBST(testTree.root);
        assert result;
    }

    // test a valid BST
    @Test
    public void testIsValidBSTWithValidBST() {
        // Create a valid binary search tree
        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(5);

        node2.childLeft = node1;
        node2.childRight = node3;
        node4.childLeft = node2;
        node4.childRight = node5;

        boolean result = ValidateBST.isValidBST(node4);
        assert result;
    }

    // test an invalid bst
    @Test
    public void testIsValidBSTWithInvalidBST() {
        // Create an invalid binary search tree
        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(5);

        node2.childLeft = node3; // Violates the BST property
        node2.childRight = node1;
        node4.childLeft = node2;
        node4.childRight = node5;

        boolean result = ValidateBST.isValidBST(node4);
        assert !result;
    }

    // test a duplicate value BST
    @Test
    public void testIsValidBSTWithInvalidBSTWithDuplicateValues() {
        // Create an invalid binary search tree with duplicate values
        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(2); // Duplicate value
        BTNode node4 = new BTNode(3);
        BTNode node5 = new BTNode(4);
        BTNode node6 = new BTNode(4); // Duplicate value

        node2.childLeft = node1;
        node2.childRight = node5;
        node5.childLeft = node3;
        node5.childRight = node6;
        node6.childRight = node4; // Violates the BST property

        boolean result = ValidateBST.isValidBST(node2);
        assert !result;
    }


}