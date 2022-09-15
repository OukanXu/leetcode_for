package P8_map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class Code03_TopologySort {
    
    public static ArrayList<Node> sortedTopology(Graph graph){
        //key: 某一个node
        //value: 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //入度为0的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        for(Node node : graph.nodes.values()){//遍历整张图，将每个点以及它的入度记录到inMap中，并将入度为0的点加入队列
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }

        //拓扑排序的结果，一次加入result
        ArrayList<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);//放置拓扑排序的结果
            for(Node next : cur.nexts){//对于每个0入度的节点，将节点从zeroInQueue弹出后，对该节点的每个相邻节点入度-1
                inMap.put(next, inMap.get(next)-1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);//将-1后入度为0的点加入0入度队列
                }
            }
        }
        return result;
    }
}
