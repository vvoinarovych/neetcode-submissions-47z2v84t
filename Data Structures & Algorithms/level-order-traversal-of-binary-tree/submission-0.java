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
        result.add(List.of(root.val));

        while(true){
            List<TreeNode> current = new ArrayList<>();
            List<Integer> currentInt = new ArrayList<>();
            for(TreeNode node : row){
                if(node.left != null){
                    current.add(node.left);
                    currentInt.add(node.left.val);
                }
                if(node.right != null){
                    current.add(node.right);
                    currentInt.add(node.right.val);
                }
            }
            if(current.isEmpty()){
                break;
            }
            result.add(currentInt);
            row = current;
        }
        return result;
    }
}
