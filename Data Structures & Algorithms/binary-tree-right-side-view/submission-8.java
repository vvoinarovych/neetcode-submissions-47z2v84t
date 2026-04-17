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
        List<TreeNode> currentLvl = new ArrayList<>();
        currentLvl.add(root);
        while(!currentLvl.isEmpty()){
            List<TreeNode> nextLvl = new ArrayList<>();
            //List<Integer> currentVals = new ArrayList<>();
            int currentVal = -1;
            for(TreeNode node : currentLvl){
                currentVal = node.val;
                if(node.left != null){
                    nextLvl.add(node.left);
                }
                if(node.right != null){
                    nextLvl.add(node.right);
                }
            }
            result.add(currentVal);
            currentLvl = nextLvl;
        }
        return result;
    }
}
