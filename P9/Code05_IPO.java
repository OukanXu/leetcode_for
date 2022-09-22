package P9;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code05_IPO {
    public static class Node{
        public int p;//profit
        public int c;//cost

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            return o2.p - o1.p;
        }
    }




    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        for(int i = 0; i < Profits.length; i++){
            minCostQ.add(new Node(Profits[i],Capital[i]));
        }

        for(int i = 0; i < k; i++){//总共进行k个项目
            //能做的项目全解锁
            while(!minCostQ.isEmpty() && minCostQ.peek().c <= W){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
