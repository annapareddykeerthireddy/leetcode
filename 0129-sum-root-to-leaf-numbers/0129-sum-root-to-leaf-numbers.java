class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the formed number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Otherwise, sum paths from left and right children
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
