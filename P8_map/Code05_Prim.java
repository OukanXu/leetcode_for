package P8_map;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;

public class Code05_Prim {
    
    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compara(Edge o1,Edge o2){
            return o1.weight-o2.weight;
        }
    }


    public static Set<Edge> primMST(Graph graph){

        //所有解锁的边放入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeCompatator());

        HashSet<Node> set = new HashSet<>();//考察过的点放入

        Set<Edge> result = new HashSet<>();//依次挑选的边，就是最小生成树

        for(Node node : graph.nodes.values()){//随便挑选一个点//处理森林问题（出现多个不连通的图）

            if(!set.contains(node)){
                set.add(node);
                for(Edge edge : node.edges){//将这个点所有的边放入优先级队列，相当于排序
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();//从优先级队列中拿出最小的边
                    Node toNode = edge.to;// 找一下这个边的to点，或许是新节点
                    if(!set.contains(toNode)){//如果to点不在考察过的点里面，说明是新的点，执行下面操作
                        set.add(toNode);//将这个新的点加入已考察的set中
                        result.add(edge);//将这条最小边加入结果中
                        for(Edge nextEdge : toNode.edges){//将这个新节点发散出来的所有边放入优先级队列中，重复的边也会放进去
                                                            //但是因为重复边的to节点已经在set中，所以可以跳过
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
