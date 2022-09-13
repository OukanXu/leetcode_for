package P7_tree;

import java.util.ArrayList;

public class checkBST {
    public static int preValue = Integer.MIN_VALUE;

    //判断是否为搜索二叉树
    public static boolean checkBST(Node head){
        if(head == null){
            return true;
        }

        boolean isLeftBst = checkBST(head.left);
        if(!isLeftBst){
            return false;
        }
        if(head.value <= preValue){
            return false;
        }else{
            preValue = head.value;
        }
        return checkBST(head.right);
    }


    //递归判断BTS
    public static boolean checkBST2(Node head){
        List<Node> inOrderList = new ArrayList<>();
        process(head, inOrderList);
        //循环判断是否升序
        for循环
    }
    //中序遍历改版，将打印变为加入队列
    public static void process(Node head, List<Node> inOrderList){
        if(head == null){
            return;
        }
        process(head.left, inOrderList);
        inOrderList.add(head);
        process(head.right, inOrderList);
    }


    //非递归判断BST 非递归中序改版，在打印时换成判断value是否升序
    public static boolean checkBST3(Node head){
        if(head != null){
            int preValue = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty() || head != null){
                //将左边界压栈
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    
                    if(head.value <= preValue){
                        return false;
                    }else{
                        preValue = head.value;
                    }

                    head = head.right;
                }
            }
        }
        return true;
    }


    //套路
    /*套路: 向左树要信息，向右树要信息
    搜索二叉树：左子树是搜索二叉树，右子树是搜索二叉树，左子树最大值小于自身，自身小于右子树最小值
    信息：左：是否搜索二叉树，最大值  右：是否搜索二叉树，最小值。 所以返回三个信息： 是否为搜索二叉树，最大值，最小值
     */

    //设置返回值，三个参数
    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean is, int mi, int ma){
            isBST = is;
            min = mi;
            max = ma;
        }
    }

    public static ReturnData process(Node x){
        if(x == null){//初始条件比较繁琐，放在下面进行讨论
            return null;
        }

        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);

        
        int max = x.value;
        int min = x.value;
        if(leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        boolean isBST = true;
        if(leftData != null && (!leftData.isBST || leftData.max > x.value)){
            isBST = false;
        }
        if(rightData != null && (!rightData.isBST || rightData.min < x.value)){
            isBST = false;
        }



        return new ReturnData(isBST, min, max);
    }

}
