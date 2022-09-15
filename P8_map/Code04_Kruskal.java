package P8_map;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Code04_Kruskal{

    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind();//生成一个并查集结构，可以快速合并集合

        unionFind.makeSets(graph.nodes.values());//对每个value设置一个集合

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());//比较器，将边从小到大排序

        for(Edge edge : graph.edges){//M条边
            priorityQueue.add(edge);//O(logM)
        }

        HashSet<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();//当每条边弹出时，
            if(!unionFind.isSameSet(edge.from,edge.to)){//看看该边的 from 和 to是不是一个集合中的
                result.add(edge);//如果不是一个集合里的，我要这条边
                unionFind.union(edge.from,edge.to);//加完边之后，把边的from所在集合和to所在集合合并
            }
        }
        return result;

    }

}