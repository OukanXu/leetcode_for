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
class Solution_Using_Stack {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        int count = 0;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast != null && fast.next != null ){
            fast = fast.next;
            count = count+1;
            if(fast.next != null){
                fast = fast.next;
                count = count+1;
            }
            
            
            slow = slow.next;
            deque.add(slow.val);
        }

        if(count == 1){
            return true;
        }

        if(count%2 == 0){
            slow = slow.next;
        }

        while(!deque.isEmpty() && slow != null){
            if(deque.peekLast() == slow.val){
                deque.pollLast();
                slow = slow.next;
            }else{
                return false;
            }
        }
        return true;
    }
}




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
class Solution_Reverse_List {
    public boolean isPalindrome(ListNode head) {

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(fast != null && slow != null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;

        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}





