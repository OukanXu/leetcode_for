package P6_list;

public class bothLoop {
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2 ){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;// or  return loop2
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }






    public static Node getIntersectNode(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if(loop1 == null && loop2 == null){
            return noloop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }
}
