/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null || fast != null){
            slow = slow.next;
            if(slow == null){
                return false;
            }            
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
