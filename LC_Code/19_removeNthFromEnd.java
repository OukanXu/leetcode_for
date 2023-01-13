

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点

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

//方法一，先确定链表长度，再删除
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head);
        ListNode cur = pre;
        int length = getLength(head);
        for(int i = 1; i < length-n+1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode result = pre.next;
        return result;   
    }

    public int getLength(ListNode head){
            int len = 0;
            while(head != null){
                len++;
                head = head.next;
            }
            return len;
        }
}

//方法二，压栈，使用deque链表来实现栈的功能

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head);
        ListNode cur = pre;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while(cur != null){
            stack.addFirst(cur);
            cur = cur.next;
        }

        for(int i = 0; i < n; i++){
            stack.poll();
        }

        cur = stack.peek();
        cur.next = cur.next.next;
        return pre.next;
}
}

//方法三：使用快慢指针实现，快指针比慢指针先走N步，当快指针走到底时，慢指针走到应删除节点的前一节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head);
        ListNode fast = pre.next;
        ListNode slow = pre;
        
            for(int i = 0; i < n; i++){
                fast = fast.next;
            }
            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return pre.next;   
}
}



//round 2
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}