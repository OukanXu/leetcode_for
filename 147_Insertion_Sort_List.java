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
    public ListNode insertionSortList(ListNode head) {

        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode tail = head;
        while(tail.next != null){
            if(tail.val < tail.next.val){
                tail = tail.next;
            }else{
                ListNode dummy = pre;
                ListNode cur = tail.next;
                while(dummy.next != tail && dummy.next.val <= cur.val){
                    dummy = dummy.next;
                }
                tail.next = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
            }
        }
        return pre.next;
    }
}
