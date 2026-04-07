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
        ListNode fast = head.next;

        //find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse 2nd part
        ListNode l2head = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(l2head != null){
            ListNode temp = l2head.next;
            l2head.next = prev;
            prev = l2head;
            l2head = temp;
        }

        //unite
        l2head = prev;
        ListNode l1head = head;        
        while(l2head != null){
            ListNode l1temp = l1head.next;            
            ListNode l2temp = l2head.next;
           
            l1head.next = l2head;
            l2head.next = l1temp;

            l1head = l1temp;
            l2head = l2temp;
        }        
    }
}
