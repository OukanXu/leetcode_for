//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]


//输入：head = [0,1,2], k = 4
//输出：[2,0,1]

//方法：将链表链接成环，根据k和链表长度n计算移动步数，重新拆分环成新链表

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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        int n = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            n++;//链表长度
        }

        int moveStep = n-(k%n);//使用cur来找链表末尾，因为cur为head前一节点，所以cur变动step步为尾结点
        cur.next = head;

        for(int i = moveStep; i > 0; i--){
            cur = cur.next;
        }

        ListNode newhead = cur.next;
        cur.next = null;
        return newhead;



    }
}