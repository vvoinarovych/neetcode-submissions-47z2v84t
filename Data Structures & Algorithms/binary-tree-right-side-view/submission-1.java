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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while(!row.isEmpty()){
            Deque<Integer> dq = new ArrayDeque<>();
            List<TreeNode> nextRow = new ArrayList<>();
            for(TreeNode node : row){
                dq.push(node.val);
                if(node.left != null){
                    nextRow.add(node.left);
                }
                if(node.right != null){
                    nextRow.add(node.right);
                }
                
            }
            row = nextRow;
            result.add(dq.pop());
        }
        return result;
    }
}
