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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;
        for(int i = 0; i < left-1; i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for(int i = 0; i < right-left+1; i++){
            rightNode = rightNode.next;
        }
        
        ListNode leftNode = pre.next;
        ListNode curNode = rightNode.next;

        pre.next = null;
        rightNode.next = null;
        
        process(leftNode);
        
        pre.next = rightNode;
        leftNode.next = curNode;




        return dummy.next;
    }

    public void process(ListNode L){
        ListNode pre = null;
        ListNode cur = L;

        while(cur != null){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
    }
}