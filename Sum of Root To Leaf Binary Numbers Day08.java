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
    public int sumRootToLeaf(TreeNode root) {
        
       return dfs(root,0);
    
    }
    
    private int dfs(TreeNode node,int val) {
        if(node==null) {
            return 0;
        }
        
        int num = 2*val+node.val;
        
        return node.left==node.right ? num : dfs(node.left,num)+dfs(node.right,num);
    }
}
