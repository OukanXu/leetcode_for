package P7_tree;

import java.util.LinkedList;

public class isCBT {
    /* 
     *判断是否为完全二叉树 complete binary tree
     * 宽度优先遍历
     * 1）任一节点，有右孩子，无左孩子，false
     * 2）在1）的条件下，如果遇到第一个左右孩子不全，那么后序节点都为叶节点，否则false
     * 
     * 
     */

    public statiic boolean isCBT(Node head){
        if(head == null){
            return true;
        }
        LinkList<Node> queue = new LinkedList<>();
        //是否遇到过左右孩子不全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;

            if(
                (leaf && (l != null || r != null)) //在已经遇到不双全节点，当前节点有孩子，false
                || 
                (l == null && r != null)//左孩子为空，右孩子不为空，false 
              ){
                return false;
            }

            //队列加入左孩子
            if(l != null){
                queue.add(l);
            }
            //队列加入右孩子
            if(r != null){
                queue.add(r);
            }

            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }
}
