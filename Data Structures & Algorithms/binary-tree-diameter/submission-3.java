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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        diameter = Math.max(diameter, dfs(root.left) + dfs(root.right));
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
