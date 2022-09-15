package P8_map;
import java.util.HashSet;
import java.util.Stack;
public class Code02_DFS {
    
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        //深度优先的路径，就在栈里，最后将栈弹空，整个流程停止
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);//一个点进栈的时候处理
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);//重新把节点压回栈
                    stack.push(next);//然后再压入目前节点的一个邻居
                    set.add(next);
                    System.out.println(next.value);//邻居进栈时处理
                    break;//如果当前节点的当前邻居没进set，将当前节点重新压入栈，并且将该邻居压入栈，并且跳出循环，不看当前节点的别的邻居了。
                            //相当于从邻居节点开始重新执行出栈，寻找当前节点的邻居，如果邻居未进入set，将本身和邻居压栈的操作
                }
            }
        }
    }
}
