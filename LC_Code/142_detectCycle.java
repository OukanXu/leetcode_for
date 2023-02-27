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
    public ListNode detectCycle(ListNode head) {
        /*
            判断链表是否有环并返回入环第一节点：
            1.快慢指针：快一次两步，慢一次一步，快慢重合时，快回到头，快慢一起一次一步，再次重合时就是入环第一节点
        */ 
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        

        while(fast != slow){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
        
    }
}

//round 2
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
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
                break;
            }
        }

        if(fast.next == null){
            return null;
        }else{
            fast = dummy;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}