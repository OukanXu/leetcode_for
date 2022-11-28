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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode oddHead = new ListNode(-1);
        oddHead.next = head;
        ListNode odd = oddHead.next;

        ListNode evenHead = new ListNode(-1);
        evenHead.next = head.next;
        ListNode even = evenHead.next;

        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = even.next;

            even.next = odd.next;
            even = odd.next;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }
}