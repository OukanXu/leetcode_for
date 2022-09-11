package P6_list;

//判断一个链表是否为有环链表，如果是，返回第一个入环节点，否则返回null

/* 
使用快慢指针来判断是否有环。如果快指针最终指向null，则无环，否则快慢指针必定相遇，当两个指针相遇时，快指针回到链表开头，慢指针不动，两个指针
一次走一步，则两个指针一定在入环第一节点再次相遇！！！
*/
public class getLoopNode {
    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;//n1->slow
        Node n2 = head.next.next;//n2->fast
        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }

        n2 = head;//n2->walk again from head
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
