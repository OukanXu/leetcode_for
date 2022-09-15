package P8_map;

import java.util.HashMap;
import java.util.HashSet;

public class Code06_Dijkstra {
    
    public static HashMap<Node,Integer> dijkstra1(Node head){

        //从head出发到所有点的最小距离
        //key：从head出发到达key
        //value：从head出发到达key的最小距离
        //如果在表中，没有T的记录，含义是从head出发到T这个点的距离是正无穷
        HashMap<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);//head到自己的距离为0

        HashSet<Node> selectedNodes = new HashSet<>();//已经选过的点，加入到set，以后不碰了 

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);//distanceMap中找到一个最小的记录，但是不能是已经被选过的

        while(minNode != null){
            int distance = distanceMap.get(minNode);//查当前节点与开始节点的距离
            for(Edge edge : minNode.edges){//考察所有的边
                Node toNode = edge.to;//每一条边的终点是谁？
                if(!distanceMap.containsKey((toNode))){//代表这个边的终点没记录，说明之前是正无穷，更新这个点的距离
                    distanceMap.put(toNode, distance + edge.weight);//该节点的新距离为前一节点的value+这条边的权重
                }
                //如果该边的终点有记录，看一下之前的value和前一节点+当前边的权重哪个小，设置成小的
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);//所有操作结束后，这个最小节点进入锁，并重新找一个没选过的最小节点
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        }
        return distanceMap;
    }


    public static Node getMinDistanceAndUnselectedNode(HashMap<Node,Integer> distanceMap, HashSet<Node> touchedNodes){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;//设置全局最大值
        for(Entry<Node,Integer> entry : distanceMap.entrySet()){//遍历hashMap
            Node node = entry.getKey();//拿出当前点
            int distance = entry.getValue();//拿出当前点距离
            if(!touchedNodes.contains(node) && distance < minDistance){//保证点没被touch并且距离比minDistance小
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
