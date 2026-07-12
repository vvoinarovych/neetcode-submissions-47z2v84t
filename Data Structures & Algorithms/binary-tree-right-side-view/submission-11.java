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
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        List<Integer> result = new ArrayList<>();
        while(!cur.isEmpty()){
            result.add(cur.get(cur.size() - 1).val);
            List<TreeNode> next = new ArrayList<>();
            for(TreeNode node : cur){
                if(node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
            }
            cur = next;
        }
        return result;
    }
}
