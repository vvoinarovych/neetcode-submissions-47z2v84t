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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int pVal = p == null ? 0 : p.val;
        int qVal = q == null ? 0 : q.val;

        if(root.val > pVal && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < pVal && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }        
    }
}
