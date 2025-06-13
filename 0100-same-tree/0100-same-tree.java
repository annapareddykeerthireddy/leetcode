class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both are null, trees are the same
        if (p == null && q == null) return true;

        // One of them is null, trees are not the same
        if (p == null || q == null) return false;

        // Values don't match
        if (p.val != q.val) return false;

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
