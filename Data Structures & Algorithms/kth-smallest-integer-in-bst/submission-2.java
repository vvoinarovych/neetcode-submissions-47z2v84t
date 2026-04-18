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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode current = root;
        while(!dq.isEmpty() || current != null){
            while(current != null){
                dq.push(current);
                current = current.left;
            }
            current = dq.pop();
            k--;
            if(k == 0){
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }
}
