/* 
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
*/


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = l1!=null? l1.val : 0;
            int n2 = l2!=null? l2.val : 0;
            int sum = n1 + n2 + carry;

            if(head == null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return head;
        
    }
}


//round 2
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(l1 != null && l2 != null){
            int temp = l1.val+l2.val+carry;
            carry = temp/10;
            temp = temp%10;
            dummy.next = new ListNode(temp);
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }

        if(carry == 0){
            dummy.next = l1 == null ? l2 : l1;
            return head.next;
        }

        if(l1 == null){
            while(l2 != null){
                int temp = l2.val+carry;
                carry = temp/10;
                temp = temp%10;
                dummy.next = new ListNode(temp);
                l2 = l2.next;
                dummy = dummy.next;
            }
            if(carry == 1){
                dummy.next = new ListNode(1);
            }
        }else{
            while(l1 != null){
                int temp = l1.val+carry;
                carry = temp/10;
                temp = temp%10;
                dummy.next = new ListNode(temp);
                l1 = l1.next;
                dummy = dummy.next;
            }
            if(carry == 1){
                dummy.next = new ListNode(1);
            }
        }
        return head.next;
    }
}