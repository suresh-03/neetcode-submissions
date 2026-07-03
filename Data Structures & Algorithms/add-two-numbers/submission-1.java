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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dNode = new ListNode();
        ListNode head = dNode;
        int carry = 0;
        while(l1 != null && l2 != null){
            Result res = calculate(l1.val,l2.val,carry);
            dNode.next = new ListNode(res.r);
            carry = res.q;
            dNode = dNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            Result res = calculate(l1.val,0,carry);
            dNode.next = new ListNode(res.r);
            carry = res.q;
            dNode = dNode.next;
            l1 = l1.next;
        }

        while(l2 != null){
            Result res = calculate(0,l2.val,carry);
            dNode.next = new ListNode(res.r);
            carry = res.q;
            dNode = dNode.next;
            l2 = l2.next;
        }

        if(carry > 0){
            dNode.next = new ListNode(carry);
        }

        return head.next;
    }

    public Result calculate(int n1,int n2, int carry){
         int sum = n1 + n2 + carry;
         int r = sum % 10;
         int q = sum / 10;

         return new Result(q,r);
    }
}

class Result{
    int q;
    int r;

    public Result(int q, int r){
        this.q = q;
        this.r = r;
    }
}
