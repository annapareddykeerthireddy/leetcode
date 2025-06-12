// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base condition: root is null
        if (root == null) return null;

        // If both p and q are greater than root, LCA lies in right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both p and q are less than root, LCA lies in left subtree
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If one is on the left and one is on the right (or one is the root), root is the LCA
        else {
            return root;
        }
    }
}
