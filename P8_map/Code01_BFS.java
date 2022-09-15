package P8_map;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class Code01_BFS {
    //从node出发，进行宽度优先遍历
    public static void bfs(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();//保证一个点不要重复进队列
        queue.add(node);//出发点进入队列
        set.add(node);//出发点进入set

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if((!set.contains(next))){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
