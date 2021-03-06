/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null)
            return n1 == null && n2 == null;
        return n1.val == n2.val && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
}