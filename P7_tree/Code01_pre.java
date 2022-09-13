package P7_tree;

import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class Code01_pre {
    


    //递归先序遍历
    public static void  preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + "");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归中序遍历
    public static void  inOrderRecur(Node head){
        if(head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.value + "");
        preOrderRecur(head.right);
    }

    //递归后序遍历
    public static void  posOrderRecur(Node head){
        if(head == null){
            return;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.value + "");
    }


    //非递归先序遍历
    /*
    准备一个栈，先把头节点入栈
    1) 从栈中弹出一个节点cur
    2）打印/处理 cur
    3）先cur右孩子压栈，再左孩子压栈（如果有的话）
    4）重复上述步骤 1-3
    */
    public static void preOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add();
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value() + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
    }


    /*非递归中序遍历
     * 先把每颗子树整棵树左边界进栈
     * 在依次弹出的过程中，打印，并对弹出节点的右树重复上述操作
     * 
     */

    public static void inOrderRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty() || head != null){
                //将左边界压栈
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }









    /* 非递归后序遍历
     * 准备两个栈，一处理，一收集
     * 将头节点压入处理栈
     * 1) 从栈中弹出一个节点cur
     * 2）将cur 压入收集栈
     * 3）处理栈先压cur左孩子再压右孩子（如果有的话）
     * 4）重复上述步骤 1-3
     * 最后输出收集栈
     */
    public static void posOrderUncur(Node head){
        if(head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }
        }
        while(!s2.isEmpty()){
            System.out.println(s2.pop().value + "");
        }
    }
}
