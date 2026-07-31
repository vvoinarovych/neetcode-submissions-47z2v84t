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
        if(preorder.length == 0) return null;
        int id = -1;

        for(int i = 0; i < preorder.length; i++){
            if(inorder[i] == preorder[0]){
                id = i;
                break;
            }
        }

        TreeNode node = new TreeNode(preorder[0]);

        int[] lp = Arrays.copyOfRange(preorder, 1, 1 + id);
        int[] li = Arrays.copyOfRange(inorder, 0, id);
        node.left = buildTree(lp, li);

        int[] rp = Arrays.copyOfRange(preorder, id + 1, preorder.length);
        int[] ri = Arrays.copyOfRange(inorder, id + 1, preorder.length);
        node.right = buildTree(rp, ri);

        return node;
    }
}
