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
    int counter = 0;
    public int goodNodes(TreeNode root) {       
        dfs(root, root.val);
        return counter;
    }

    private void dfs(TreeNode node, int max){
        if(node == null) return;
        if(node.val >= max){
            counter++;
        }
        int cap = Math.max(max, node.val);
        dfs(node.left, cap);
        dfs(node.right, cap);        
    }
}
