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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = reverse(head);
        ListNode temp = dummy.next;
        ListNode pre = temp;
        temp.val++;
        int carry = 0;
        while(temp != null){
            temp.val += carry;
            carry = temp.val/10;
            temp.val %= 10;
            
            pre = temp;
            temp = temp.next;
        }
        if(carry == 1){
            ListNode tail = new ListNode(1);
            tail.next = null;
            pre.next = tail;
        }
        dummy.next = reverse(dummy.next);
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode dummy = head;
        while(head != null){
            dummy = head.next;
            head.next = pre;
            pre = head;
            head = dummy;
        }
        return pre;
    }
}
