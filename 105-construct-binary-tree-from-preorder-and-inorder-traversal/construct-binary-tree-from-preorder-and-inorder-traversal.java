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
    TreeNode func(int[] pre , int[] in , Map<Integer,Integer> m,int i1, int j1,int i2,int j2)
    {
        if(i1>j1) return null;
        TreeNode root = new TreeNode(pre[i1]);
        int k = m.get(pre[i1]);
        root.left=func(pre,in,m,i1+1,i1+(k-i2),i2,k-1);
        root.right = func(pre,in,m,i1+(k-i2)+1,j1,k+1,j2);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) 
        {
            m.put(inorder[i], i); 
        }
        return func(preorder , inorder ,m,0,preorder.length-1,0,inorder.length-1);
    }
}