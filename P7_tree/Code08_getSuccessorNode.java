package P7_tree;

public class Code08_getSuccessorNode {
    //变换node的结构，现在node有一个指向parent的指针，求后继节点序列
    //后继节点序列就是 中序遍历出来的序列

    /*
     * 1)x有右树的时候，右树上的最左节点就是后继
     * 2）x无右树，向上找，找到某个节点是其父亲的左孩子，该父亲为x的后继，如果一直找不到，后继为空
     */

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val){
            value = val;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static Node getSuccessorNode(Node node){
        if(node == null){
            return node;
        }

        if(node.right != null){
            return getLeftMost(node.right);//返回右树的最左节点
        }else{//无右子树
            Node parent = node.parent;
            while(parent != null && parent.left != node){//当前节点是其父节点的右孩子，继续向上.
                node = parent;                           //返回情况有两种：1.我是我父亲的左孩子，返回父亲
                parent = node.parent;                    //2.我是整棵树的最右节点
            }
            return parent;
        }
    }
}
