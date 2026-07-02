/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();

        Node temp = head;

        while(temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        Node newHead = new Node(-1);

        while(temp != null){
            Node newNode = map.get(temp);
            newHead.next = newNode;
            newHead = newHead.next;
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node newNode = map.get(temp);
            if(temp.random == null){
                newNode.random = null;
            }
            else{
                Node newNodeRandom = map.get(temp.random);
                newNode.random = newNodeRandom;
            }
            temp = temp.next;
        }

        return map.get(head);

    

    }
}

