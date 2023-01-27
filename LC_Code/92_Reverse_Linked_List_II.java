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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;
        for(int i = 0; i < left-1; i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for(int i = 0; i < right-left+1; i++){
            rightNode = rightNode.next;
        }
        
        ListNode leftNode = pre.next;
        ListNode curNode = rightNode.next;

        pre.next = null;
        rightNode.next = null;
        
        process(leftNode);
        
        pre.next = rightNode;
        leftNode.next = curNode;




        return dummy.next;
    }

    public void process(ListNode L){
        ListNode pre = null;
        ListNode cur = L;

        while(cur != null){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode dummy = new ListNode(501,head);

        int index = 0;
        ListNode cur = dummy;
        while(index < left-1){
            cur = cur.next;
            index++;
        }

        ListNode leftNode = cur;
        ListNode newHead = leftNode.next;

        while(index < right){
            cur = cur.next;
            index++;
        }

        ListNode rightNode = cur.next;

        leftNode.next = null;
        cur.next = null;

        reverse(newHead);

        leftNode.next = cur;
        newHead.next = rightNode;



        return dummy.next;
    }

    public void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextHead = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextHead;
        }
       
    }
}



//一次遍历，更加简单
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        for (int i = 0; i < left - 1; ++i)
            p0 = p0.next;

        ListNode pre = null, cur = p0.next;
        for (int i = 0; i < right - left + 1; ++i) {
            ListNode nxt = cur.next;
            cur.next = pre; // 每次循环只修改一个 next，方便大家理解
            pre = cur;
            cur = nxt;
        }

        // 见视频
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
