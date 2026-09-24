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
        int id = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                id = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);

        int[] pl = Arrays.copyOfRange(preorder, 1, 1 + id);
        int[] il = Arrays.copyOfRange(inorder, 0, id);
        root.left = buildTree(pl, il);

        int[] pr = Arrays.copyOfRange(preorder, id + 1, preorder.length);
        int[] ir = Arrays.copyOfRange(inorder, id + 1, inorder.length);
        root.right = buildTree(pr, ir);
        return root;
    }
}
