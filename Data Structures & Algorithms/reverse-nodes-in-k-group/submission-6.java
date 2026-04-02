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
            ListNode kth = this.findKth(groupPrev, k);
            if(kth == null){
                break;
            }
            ListNode nextGroupStart = kth.next;
            ListNode prev = nextGroupStart;
            ListNode cur = groupPrev.next;

            while(cur != nextGroupStart){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp; 
        }
        return dummy.next;
    }

    private ListNode findKth(ListNode node, int k){
        while(node != null && k > 0){
            node = node.next;
            k--;
        }
        return node;
    }
}
