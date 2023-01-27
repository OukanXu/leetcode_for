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

        ListNode cur = pre.next;

        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                cur = cur.next;
            }else{
                if(cur != null && cur.next != null){
                    cur.next = cur.next.next;
                }
            }
        }
        return pre.next;
    }
}



//round 2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101,head);

        ListNode fast = dummy.next;
        ListNode slow = dummy;

        while(fast != null){
            if(fast.val != slow.val){
                fast = fast.next;
                slow = slow.next;
            }else{
                while(fast != null && fast.val == slow.val){
                    fast = fast.next;
                }
                slow.next = fast;
            }
        }
        return dummy.next;
    }
}