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

//round 2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(101,head);

        ListNode left = dummy;
        ListNode right = dummy;
        right = right.next;
        int temp = 101;
        while(right.next != null){
            if(right.val == right.next.val){
                temp = right.val;
                while(right.val == temp && right.next != null){
                    right = right.next;
                }
                left.next = right;
            }else{
                left = left.next;
                right = right.next;
            }
        }

        if(right.val == temp){
            left.next = right.next;
        }
        return dummy.next;
    }
}