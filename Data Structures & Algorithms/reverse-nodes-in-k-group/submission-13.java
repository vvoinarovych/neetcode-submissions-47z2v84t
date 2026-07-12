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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = findKth(groupPrev, k);
            if(kth == null) break;
            ListNode nextStart = kth.next;
            ListNode prev = nextStart;
            ListNode current = groupPrev.next;

            while(current != nextStart){
                ListNode temp  = current.next;
                current.next = prev;

                prev = current;
                current = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode findKth(ListNode head, int k){
        while(head != null && k > 0){
            head = head.next;
            k--;
        }
        return head;
    }
}
