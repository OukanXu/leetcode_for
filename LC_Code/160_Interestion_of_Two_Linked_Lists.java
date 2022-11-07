/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 1;
        int lenB = 1;

        while(curA.next != null && curB.next != null){
            curA = curA.next;
            curB = curB.next;
            lenA++;
            lenB++;
        }

        while(curA.next != null){
            curA = curA.next;
            lenA++;
        }

        while(curB.next != null){
            curB = curB.next;
            lenB++;
        }

        if(curA.val != curB.val){
            return null;
        }else{
            int betweenLen = lenA > lenB ? lenA-lenB : lenB-lenA;
            ListNode move = lenA > lenB ? headA : headB;
            ListNode anotherMove = lenA > lenB ? headB : headA;
            for(int i = betweenLen; i > 0; i--){
                move = move.next;
            }

            while(move != null && anotherMove != null && move != anotherMove){
                move = move.next;
                anotherMove = anotherMove.next;
            }
            return move;
        }
    }
}