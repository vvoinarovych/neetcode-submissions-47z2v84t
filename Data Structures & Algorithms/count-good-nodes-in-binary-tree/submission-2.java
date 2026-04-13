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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, root.val);
    }
     private int dfs(TreeNode node, int max){
        if(node == null){
            return 0;
        }
        int toAdd = node.val >= max ? 1 : 0;
        int currentMax = Math.max(max, node.val);
            
        return toAdd + dfs(node.left, currentMax) + dfs(node.right, currentMax); 
     }
}
