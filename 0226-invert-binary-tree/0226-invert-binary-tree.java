class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
