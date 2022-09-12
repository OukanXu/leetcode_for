
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
    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0,head);
        if(pre.next == null || pre.next.next == null){
            return head;
        }

        ListNode cur = pre;
        ListNode less = pre;

        while(cur != null && cur.next != null){
            if(cur.next.val >= x){
                cur = cur.next;
            }else{
                if(less == cur){
                    less = cur.next;
                    cur = cur.next;
                }else{
                    ListNode temp = cur.next;
                    ListNode large = less.next;
                    cur.next = temp.next;
                    temp.next = large;
                    less.next = temp;
                    less = less.next;  
                }
                
            }
        }
    return pre.next;
    }
}