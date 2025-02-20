/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int func(TreeNode root)
    {
        if(root == null) return 0;
        int left =Integer.MAX_VALUE;
        int right =Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return 1;
        if(root.left != null)
        {
            left = 1+func(root.left);
        }
        if(root.right != null)
        {
            right = 1+ func(root.right);
        }
        return Math.min(left,right);
    }
    public int minDepth(TreeNode root) {
        return func(root);
    }
}