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
        int id = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                id = i;
                break;
            }
        }
        int[] lp = Arrays.copyOfRange(preorder, 1, 1 + id);
        int[] li = Arrays.copyOfRange(inorder, 0, id + 1);
        node.left = buildTree(lp, li);

        int[] rp = Arrays.copyOfRange(preorder, 1 + id, preorder.length);
        int[] ri = Arrays.copyOfRange(inorder, 1 + id, inorder.length);
        node.right = buildTree(rp, ri);

        return node;
    }
}
