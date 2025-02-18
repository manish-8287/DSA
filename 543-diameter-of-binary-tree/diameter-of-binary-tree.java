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
    int func(TreeNode root , int[] d)
    {
        if(root == null) { 
            return 0;
        }
        int left = func(root.left,d);
        int right = func(root.right,d);
        d[0]= Math.max(d[0],(left+right));
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        func(root,diameter);
        return diameter[0];
    }
}