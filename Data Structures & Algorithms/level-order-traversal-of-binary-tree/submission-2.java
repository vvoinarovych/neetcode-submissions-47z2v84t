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
        if(root == null) return List.of();
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> currentLvl = new ArrayList<>();
        currentLvl.add(root);

        while(!currentLvl.isEmpty()){
            List<Integer> values = new ArrayList<>();
            List<TreeNode> nextLvl = new ArrayList<>();
            for(TreeNode node: currentLvl){
                values.add(node.val);
                if(node.left != null){
                    nextLvl.add(node.left);
                }
                if(node.right != null){
                    nextLvl.add(node.right);
                }
            }
            result.add(values);
            currentLvl = nextLvl;
        }
        return result;
    }
}
