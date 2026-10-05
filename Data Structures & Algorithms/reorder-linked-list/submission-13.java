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
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode cur = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        ListNode l1 = head;
        ListNode l2 = prev;        

        while(l2 != null){
            ListNode l1temp = l1.next;
            ListNode l2temp = l2.next;
            l1.next = l2;
            l2.next = l1temp;

            l1 = l1temp;
            l2 = l2temp;
        }

    }
}
