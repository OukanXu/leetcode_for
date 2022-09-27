package P14_Tree_DP;

public class Code02_MaxDistanceInTree {
    
    public static class Info{
        public int maxDistance;
        public int height;
        public Info(int dis, int h){
            maxDistance = dis;
            height = h;
        }
    }



    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    // 返回以x为头的整棵树的信息
    public static Info process(Node x){
        if(x == null){
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3= leftInfo.height + rightInfo.height + 1;

        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height) +1;
        return new Info(maxDistance, height);
    }
}
