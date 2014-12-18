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
    public void flatten(TreeNode root) {
        joint(root, null);
    }
    
    private TreeNode joint(TreeNode root, TreeNode tail) {
        if (root == null)
            return tail;
        root.right = joint(root.left, joint(root.right, tail));
        root.left = null;
        return root;
    }
}