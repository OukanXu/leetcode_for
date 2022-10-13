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
    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head,ListNode tail) {
        
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;

        
        ListNode left = sortList(head,mid);
        ListNode right = sortList(mid,tail);
        ListNode sorted = merge(left,right);
        return sorted;
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode temp = dummy;
        ListNode tempLeft = left;
        ListNode tempRight = right;

        while(tempLeft != null && tempRight != null){
            if(tempLeft.val < tempRight.val){
                temp.next = tempLeft;
                temp = temp.next;
                tempLeft = tempLeft.next;
            }else{
                temp.next = tempRight;
                temp = temp.next;
                tempRight = tempRight.next;
            }
        }

        if(tempLeft != null){
            temp.next = tempLeft;
        }else if(tempRight != null){
            temp.next = tempRight;
        }

        return dummy.next;
        
    }
}