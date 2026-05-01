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
        List<TreeNode> cLvl = new ArrayList<>();
        cLvl.add(root);

        while(!cLvl.isEmpty()){
            List<TreeNode> nextLvl = new ArrayList<>();
            TreeNode right = cLvl.get(cLvl.size() - 1);
            result.add(right.val);
            for(TreeNode node : cLvl){
                if(node.left != null) nextLvl.add(node.left);
                if(node.right != null) nextLvl.add(node.right);                
            }
            cLvl = nextLvl;
        }
        return result;
    }
}
