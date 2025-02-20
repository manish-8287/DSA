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
    TreeNode func(int[] in, int[] post, int i1 , int j1 , int i2 , int j2 ,Map<Integer,Integer> m)
    {
        if(i1>j1) return null;
        TreeNode root = new TreeNode(post[j2]);
        int k = m.get(root.val);
        root.right = func(in, post, k + 1, j1, i2 + k - i1, j2 - 1, m);
        root.left = func(in, post, i1, k - 1, i2, i2 + k - i1 - 1, m);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            m.put(inorder[i] , i);
        }
       return func(inorder , postorder , 0 , inorder.length-1 , 0 , postorder.length-1,m);
    }
}