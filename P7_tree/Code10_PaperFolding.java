package P7_tree;

public class Code10_PaperFolding {
    /*
     * 取一张长条纸，抓住上端对折，再对折，。。。
     * 给一个参数n，代表对折几次，求纸条从上到下，折痕的顺序
     * 
     * 就是二叉树中序遍历，在该树中，每个左子树的头为凹，每个右子树的头为凸
     * 
     */


    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }
    //递归过程，来到某个节点
    //i是节点的层数，N是一共的层数， down == true 凹， down == false 凸


    public static void printProcess(int i, int N, boolean down){
        if(i > N){
            return;
        }
        printProcess(i+1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i+1, N, false);

    }

    public static void main(String[] args){
        int N = 3;
        printAllFolds(N);
    }
}
