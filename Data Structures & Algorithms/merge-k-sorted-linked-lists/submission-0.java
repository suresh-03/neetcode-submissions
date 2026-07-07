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
    public ListNode mergeKLists(ListNode[] lists) {
       ListNode head = null;

       for(int i = 0; i < lists.length; i++){
            head = merge2Lists(lists[i],head);
       }

       return head;

    }

    public ListNode merge2Lists(ListNode node1, ListNode node2){
        ListNode dNode = new ListNode();
        ListNode temp = dNode;

        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                temp.next = node1;
                node1 = node1.next;
            }
            else{
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        if(node1 == null){
            temp.next = node2;
        }
        if(node2 == null){
            temp.next = node1;
        }

        return dNode.next;
    }
}
