import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class BTTest {
    //add a single node
    @Test
    public void testAddNode() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        assert tree.root.data == 5;
    }

    //add a multiple nodes
    @Test
    public void testAddNodes() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);

        List<BTNode> preOrderList = new ArrayList<>();
        tree.preOrder(tree.root, preOrderList);
        assert preOrderList.get(0).data == 5;
        assert preOrderList.get(1).data == 3;
        assert preOrderList.get(2).data == 2;
        assert preOrderList.get(3).data == 4;
        assert preOrderList.get(4).data == 7;
        assert preOrderList.get(5).data == 6;
        assert preOrderList.get(6).data == 8;

    }

    //find node
    @Test
    public void testFindNode() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);

        BTNode node = tree.findNode(3, tree.root);
        assert node.data == 3;
    }

    // find missing node
    @Test
    public void testFindMissingNode() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);

        BTNode node = tree.findNode(10, tree.root);
        assert node == null;
    }

    // pre order traversal test
    @Test
    public void testPreOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);

        List<BTNode> preOrderList = new ArrayList<>();
        tree.preOrder(tree.root, preOrderList);
        assert preOrderList.get(0).data == 5;
        assert preOrderList.get(1).data == 3;
        assert preOrderList.get(2).data == 2;
        assert preOrderList.get(3).data == 4;
        assert preOrderList.get(4).data == 7;
        assert preOrderList.get(5).data == 6;
        assert preOrderList.get(6).data == 8;
    }

    // post order traversal test
    @Test
    public void testPostOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);

        List<BTNode> postOrderList = new ArrayList<>();
        tree.postOrder(tree.root, postOrderList);
        assert postOrderList.get(0).data == 2;
        assert postOrderList.get(1).data == 4;
        assert postOrderList.get(2).data == 3;
        assert postOrderList.get(3).data == 6;
        assert postOrderList.get(4).data == 8;
        assert postOrderList.get(5).data == 7;
        assert postOrderList.get(6).data == 5;
    }

    // in-order traversal test
    @Test
    public void testInOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);

        List<BTNode> inOrderList = new ArrayList<>();
        tree.inOrder(tree.root, inOrderList);
        assert inOrderList.get(0).data == 2;
        assert inOrderList.get(1).data == 3;
        assert inOrderList.get(2).data == 4;
        assert inOrderList.get(3).data == 5;
        assert inOrderList.get(4).data == 6;
        assert inOrderList.get(5).data == 7;
        assert inOrderList.get(6).data == 8;
    }

}