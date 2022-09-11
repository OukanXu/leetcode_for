public static Node noLoop(Node head1, Node head2){
    if(head1 == null || head2 == null){
        return null;
    }

    Node cur1 = head1;
    Node cur2 = head2;
    int n = 0;//链表1长度-链表2长度的值
    while(cur1.next != null){
        n++;
        cur1 = cur1.next;
    }
    while(cur2.next != null){
        n--;
        cur2 = cur2.next;
    }

    if(cur1 != cur2){//若末节点不相等，则无相交节点
        return null;
    }

    cur1 = n > 0 ? head1 : head2;//谁长，谁的头变成cur1
    cur2 = cur1 == head1 ? head2 : head1;//谁短，谁的头变成cur2

    n = Math.asb(n);
    while(n != 0){
        n--;
        cur1 = cur1.next;
    }
    while(cur1 != cur2){
        cur1 = cur1.next;
        cur2 = cur2.next;
    }
    return cur1;
}