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
        ListNode gPrev = dummy;

        while(true){
            ListNode kth = this.findKth(gPrev, k);
            if(kth == null) break;
            ListNode nextStart = kth.next;
            ListNode cur = gPrev.next;
            ListNode prev = nextStart;

            while(cur != nextStart){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            ListNode temp = gPrev.next;
            gPrev.next = kth;
            gPrev = temp;
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
