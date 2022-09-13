package P7_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Code09_SerializeAndReconstructTree {
    public static class Node{
        public Node left;
        public Node right;
        public int value;
        public Node(int val){
            val = value;
        }
    }

    //以head为头的树，按照先序遍历完成序列化
    public static String serialByPre(Node head){
        if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }



    //反序列化
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i != values.length; i++){
            queue.add(values[i]);
        }

        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
