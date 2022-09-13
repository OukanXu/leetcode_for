package P7_tree;

import java.util.HashMap;
import java.util.HashSet;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class Code07_LowestCommonAncestor {
    //已知两个点node1和node2，求他们的最低公共祖先

    //设置fatherMap，可以找到目前节点的father
    public static void process(Node head, HashMap<Node, Node> fatherMap){
        if(head == null){
            return;
        }

        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);

        process(head.left,fatherMap);
        process(head.right,fatherMap);
    }

    public static Node lca(Node head, Node o1, Node o2){
        if(head == null){
            return head;
        }

        HashMap<Node,Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();

        //set1 为o1往上所有父节点的哈希表
        Node cur = o1;
        while(cur != fatherMap.get(cur)){
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        while(o2 != fatherMap.get(o2)){
            if(!set1.contains(o2)){
                o2 = fatherMap.get(o2);
            }else{
                return o2;
            }
        }
        return null;

    }


    //解法二
    public static Node lowestAncestor(Node head, Node o1, Node o2){
        if(head == null || head == o1 || head == o2){
            return head;
        }

        Node left = lowestAncestor(head.left,o1,o2);
        Node right = lowestAncestor(head.right,o1,o2);

        //两颗子树都有返回值，说明o1和o2分别在子树上，返回当前的公共节点
        if(left != null && right != null){
            return head;
        }
        //两个子树至少有一个没有返回值，返回有返回值的
        return left != null ? left : right;
    }
}
