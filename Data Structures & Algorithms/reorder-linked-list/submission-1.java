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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        //reverse
        ListNode prev = null;
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;

            prev = second;
            second = temp;
        }

        //unite
        ListNode first = head;
        second = prev;
        
        while(second != null){
            ListNode ftemp = first.next;
            ListNode stemp = second.next;

            second.next = first.next;
            first.next = second;

            first = ftemp;
            second = stemp;
        }
    }
}
