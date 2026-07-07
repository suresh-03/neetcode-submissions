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
        if(lists.length == 0){
            return null;
        }
       return mergeSort(lists,0,lists.length-1);
    }

    public ListNode mergeSort(ListNode[] lists, int s, int e){
        if(s == e){
            return lists[s];
        }

        int m = (s+e)/2;

        ListNode n1 = mergeSort(lists,s,m);
        ListNode n2 = mergeSort(lists,m+1,e);

        return merge2Lists(n1,n2);
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
