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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        int nodeToRemove = size - n;

        temp = head;
        ListNode prev = null;
        int index = 0;

        while(temp != null){
            if(index == nodeToRemove){
                if(prev != null){
                    prev.next = temp.next;
                    return head;
                }
                else{
                    return head.next;
                }
            }
            prev = temp;
            temp = temp.next;
            index++;
        }

        return null;
    }
}
