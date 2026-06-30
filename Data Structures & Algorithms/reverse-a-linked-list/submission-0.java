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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = p2.next;

        while(p3 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        p2.next = p1;
        return p2;
    }
}
