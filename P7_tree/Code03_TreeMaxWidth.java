package P7_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class Code03_TreeMaxWidth {
    //宽度优先遍历
    public static void w(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    //获取最大宽度
    public static int getMaxWidth(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node,Integer> levelMap = new HashMap<>();
        //将头节点就如hashmap
        levelMap.put(head,1);
        //  设置目前层数，目前层节点数，和一个最大值
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;


        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);//获取当前节点的层数
            if(curNodeLevel == curLevel){//如果当前节点的层数与当前层数相同，当前节点数+1
                curLevelNodes++;
            }else{//如果当前节点的层数与当前层数不同，说明上一层已经完成，更新max，更新层数和当前层节点数
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            
            if(cur.left != null){
                levelMap.put(cur.left, curNodeLevel+1);//如果有左孩子，将左孩子加入到hashmap
                queue.add(cur.left);
            }
            if(cur.right != null){
                levelMap.put(cur.right, curNodeLevel+1);//如果有右孩子，将右孩子加入到hashmap
                queue.add(cur.right);
            }
        }
        return max;
    }
}
