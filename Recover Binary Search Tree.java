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
    
    private TreeNode m1 = null;
    private TreeNode m2 = null;
    private TreeNode last = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = m1.val;
        m1.val = m2.val;
        m2.val = temp;
    }
    
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (m1 == null && root.val < last.val)
            m1 = last;
        if (m1 != null && root.val < last.val)
            m2 = root;
        last = root;
        traverse(root.right);
    }
}