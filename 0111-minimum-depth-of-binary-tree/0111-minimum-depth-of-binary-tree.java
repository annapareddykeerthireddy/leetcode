class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If one child is null, return depth of the other subtree + 1
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        // If both children exist, return the minimum of the two depths
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
