//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。


//输入：head = [1,2,3,4]
//输出：[2,1,4,3]

//输入：head = []
//输出：[]

//输入：head = [1]
//输出：[1]


//方法一：迭代法，生成一个temp节点，n1节点和n2节点，temp->n1->n2，将n1、n2变换位置，将temp变为n1重复上述操作
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
    public ListNode swapPairs(ListNode head) {
       ListNode pre = new ListNode(0,head);
       ListNode temp = pre;

       while(temp.next != null && temp.next.next != null){
           ListNode n1 = temp.next;
           ListNode n2 = temp.next.next;

           temp.next = n2;
           n1.next = n2.next;
           n2.next = n1;
           temp = n1;
       }
       return pre.next;

    }
}


//方法二：递归法

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
    public ListNode swapPairs(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }
       ListNode newhead = head.next;
       head.next = swapPairs(newhead.next);
       newhead.next = head;
       return newhead;

    }
}