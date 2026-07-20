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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int nodeId = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                nodeId = i;
                break;
            }
        }
        int[] lp = Arrays.copyOfRange(preorder, 1, nodeId + 1);
        int[] li = Arrays.copyOfRange(inorder, 0, nodeId);
        node.left = buildTree(lp, li);

        int[] rp = Arrays.copyOfRange(preorder, nodeId + 1, preorder.length);
        int[] ri = Arrays.copyOfRange(inorder, nodeId + 1, preorder.length);
        node.right = buildTree(rp, ri);

        return node;
    }
}
