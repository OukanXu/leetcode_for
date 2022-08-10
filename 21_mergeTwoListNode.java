
  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {

    //digui  recrusive
    /*public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    } */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode temp = new ListNode(-1);
        
        ListNode head = new ListNode(-1);
        
        //截取head
        if(list1.val < list2.val){
            head = list1;
            temp = list1;
            list1 = list1.next;
        }else{
            head = list2;
            temp = list2;
            list2 = list2.next;
        }
        
        while(list1 != null || list2 != null){
            //当一个链表结束时，将另一个链表截取上去
            if(list1 == null && list2 != null){
                temp.next = list2;
                break;
            }else if(list1 != null && list2 == null){
                temp.next = list1;
                break;
            }
            
            //哪个链表小截取哪个
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        return head;
    }
}