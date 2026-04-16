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
        return isGood(root, root.val);
    }
    private int isGood(TreeNode node, int max){
        if(node == null){
            return 0;
        }
        int newMax = Math.max(max, node.val);
        int toAdd = node.val >= max? 1 : 0;
        
        return toAdd + isGood(node.left, newMax) + isGood(node.right, newMax);
    }
}
