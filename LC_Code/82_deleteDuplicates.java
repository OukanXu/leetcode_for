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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0,head);

        if(pre.next == null || pre.next.next == null){
            return head;
        }

        ListNode cur = pre;
        while(cur.next != null&& cur.next.next != null){
            if(cur.next.val != cur.next.next.val){
                cur = cur.next;
            }else{
                int x = cur.next.val;
                ListNode newNode = cur.next;
                while(newNode != null && newNode.val == x){
                    newNode = newNode.next;
                }
                cur.next = newNode;
            }
            
        }
        return pre.next;
    }
}