
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
    HashMap<Node,Node> tempNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        if(!tempNode.containsKey(head)){
            Node newHead = new Node(head.val);
            tempNode.put(head,newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
            return newHead;
        }
        return tempNode.get(head);
    }
}