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
        if(root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        List<TreeNode> lvl = new ArrayList<>();
        lvl.add(root);
        while(!lvl.isEmpty()){
            List<TreeNode> nextLvl = new ArrayList<>();
            for(TreeNode node : lvl){
                if(node.left != null){
                    nextLvl.add(node.left);
                }
                if(node.right != null){
                    nextLvl.add(node.right);
                }
            }
            var last = lvl.get(lvl.size() - 1);
            result.add(last.val);
            lvl = nextLvl;
        }
        return result;
    }
}
