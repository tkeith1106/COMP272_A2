import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeOrderTest {
    @Test
    public void testPreOrderNumber() {
        PPIBinaryTree tree = new PPIBinaryTree();
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(7);
        tree.addNode(1);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(8);
        tree.preOrderNumber();

        assertEquals(0, tree.root.preOrderNumber);
        assertEquals(1, tree.root.childLeft.preOrderNumber);
        assertEquals(2, tree.root.childLeft.childLeft.preOrderNumber);
        assertEquals(3, tree.root.childLeft.childRight.preOrderNumber);
        assertEquals(4, tree.root.childRight.preOrderNumber);
        assertEquals(5, tree.root.childRight.childLeft.preOrderNumber);
        assertEquals(6, tree.root.childRight.childRight.preOrderNumber);
    }

    @Test
    public void testPostOrderNumber() {
        PPIBinaryTree tree = new PPIBinaryTree();
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(7);
        tree.addNode(1);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(8);
        tree.postOrderNumber();

        assertEquals(0, tree.root.childLeft.childLeft.postOrderNumber);
        assertEquals(1, tree.root.childLeft.childRight.postOrderNumber);
        assertEquals(2, tree.root.childLeft.postOrderNumber);
        assertEquals(3, tree.root.childRight.childLeft.postOrderNumber);
        assertEquals(4, tree.root.childRight.childRight.postOrderNumber);
        assertEquals(5, tree.root.childRight.postOrderNumber);
        assertEquals(6, tree.root.postOrderNumber);
    }

    @Test
    public void testInOrderNumber() {
        PPIBinaryTree tree = new PPIBinaryTree();
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(7);
        tree.addNode(1);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(8);
        tree.inOrderNumber();

        assertEquals(0, tree.root.childLeft.childLeft.inOrderNumber);
        assertEquals(1, tree.root.childLeft.inOrderNumber);
        assertEquals(2, tree.root.childLeft.childRight.inOrderNumber);
        assertEquals(3, tree.root.inOrderNumber);
        assertEquals(4, tree.root.childRight.childLeft.inOrderNumber);
        assertEquals(5, tree.root.childRight.inOrderNumber);
        assertEquals(6, tree.root.childRight.childRight.inOrderNumber);
    }
}