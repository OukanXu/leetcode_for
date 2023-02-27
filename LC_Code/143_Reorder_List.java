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
    public void reorderList(ListNode head) {

        ArrayList<ListNode> arr = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            arr.add(temp);
            temp = temp.next;
        }

        int left = 0;
        int right = arr.size()-1;
        while(left < right){
            arr.get(left).next = arr.get(right);
            left++;
            if(left == right){
                break;
            }
            arr.get(right).next = arr.get(left);
            right--;
        }
        arr.get(left).next = null;
    }
}


//round 2
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
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
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = reverse(slow.next);

        slow.next = null;
        ListNode head1 = dummy.next;
        ListNode head2 = newHead.next;

        ListNode l1;
        ListNode l2;

        while(head1 != null && head2 != null){
            l1 = head1.next;
            l2 = head2.next;

            head1.next = head2;
            head1 = l1;
            
            head2.next = head1;
            head2 = l2;
        }
        
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;
    }
}