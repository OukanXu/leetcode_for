package P7_tree;

public class isFullTree {
    /*
     * 满二叉树： 需要知道高度height，节点个数N， N = 2^height-1
     */

    public static class Info{
        public int height;
        public int nodes;

        public Info(int h, int n){
            height = h;
            nodes = n;
        }
    }

    public static Info process(Node x){
        if(x == null){
            return new Info(0, 0);
        }

        Info leftData = process(x.left);
        Info rightData = process(x.right);

        int height;
        int nodes;
        height = Math.max(leftData.height, rightData.height) + 1;
        nodes = leftData.nodes + rightData.nodes +1;

        return new Info(height, nodes);
    }

    public static boolean isFullTree(Node head){
        if(head == null){
            return true;
        }
        Info data = process(head);

        if(data.nodes == (2^data.height)-1){
            return true;
        }else{
            return false;
        }
    }
}
