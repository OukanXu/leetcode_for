/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode pre = new ListNode(0,head);
        ListNode fast = pre;
        ListNode slow = pre;

        if(pre.next == null || pre.next.next == null){
            return false;
        }

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
        
    }
}


//round 2
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next;
            }

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}