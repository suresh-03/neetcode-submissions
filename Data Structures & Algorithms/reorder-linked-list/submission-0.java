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
        ListNode node1 = head;
        ListNode temp = head;
        ListNode middleNode = findMiddleNode(head);
        ListNode node2 = middleNode.next;
        middleNode.next = null;
        node2 = reverseList(node2);

        ListNode dNode = new ListNode();

        boolean takeN1 = true;

        while(node1 != null && node2 != null){
            if(takeN1){
                dNode.next = node1;
                node1 = node1.next;
            }
            else{
                dNode.next = node2;
                node2 = node2.next;
            }
            dNode = dNode.next;
            takeN1 = takeN1 ? false : true;
        }

        if(node1 == null){
            dNode.next = node2;
        }
        if(node2 == null){
            dNode.next = node1;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
