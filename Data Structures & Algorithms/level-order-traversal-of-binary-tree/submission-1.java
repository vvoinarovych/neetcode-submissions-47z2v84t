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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> row = new ArrayList<>();
        row.add(root);

        while(!row.isEmpty()){
            List<Integer> vals = new ArrayList<>();
            List<TreeNode> nextRow = new ArrayList<>();
            for(TreeNode node : row){
                vals.add(node.val);
                if(node.left != null){
                    nextRow.add(node.left);
                }
                if(node.right != null){
                    nextRow.add(node.right);
                }
            }
            result.add(vals);
            row = nextRow;
        }
        return result;
    }
}
