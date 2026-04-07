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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        if(dfs(root.left) == -1){
            return -1;
        }
        if(dfs(root.right) == -1){
            return -1;
        }
        if(Math.abs(dfs(root.left) - dfs(root.right)) > 1){
            return -1;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
