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

//round 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;
        if(lengthA > lengthB){
            for(int i = 0; i < lengthA-lengthB; i++){
                tempA = tempA.next;
            }
        }else{
            for(int i = 0; i < lengthB-lengthA; i++){
                tempB = tempB.next;
            }
        }

        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA == null ? null : tempA;
    }

    public int getLength(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}