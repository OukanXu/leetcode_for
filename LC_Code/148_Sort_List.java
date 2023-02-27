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


//round 2
class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }


    public ListNode sort(ListNode head, ListNode tail){
        if(head == null){
            return null;
        }else if(head.next == tail){
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

        
        ListNode left = sort(head,mid);
        ListNode right = sort(mid,tail);
        ListNode sorted = merge(left,right);
        return sorted;
    }

    public ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        ListNode h1 = leftHead;
        ListNode h2 = rightHead;

        ListNode temp = dummy;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }

        if(h1 == null){
            temp.next = h2;
        }else{
            temp.next = h1;
        }

        return dummy.next;
    }
}