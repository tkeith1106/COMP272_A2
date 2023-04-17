public class ValidateBST {
    public static boolean isValidBST(BTNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // recursive method of O(1)
    private static boolean isValidBST(BTNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }

        // Check if the node's value is within the valid range
        if (node.data <= minVal || node.data >= maxVal) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isValidBST(node.childLeft, minVal, node.data) && isValidBST(node.childRight, node.data, maxVal);
    }
}