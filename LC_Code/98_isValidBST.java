
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /*
    重新构筑返回值，本节点向左右子树问询：1.是否为BST，2.最大值， 3.最小值
     */

    public class ReturnType{
        boolean isBST;
        int max;
        int min;
        public ReturnType(boolean isB,int mi,int ma){
            isBST = isB;
            max = ma;
            min = mi;
        }
    }

    //主函数
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        ReturnType data = process(root);
        return data.isBST;

    }

    //递归函数
    public ReturnType process(TreeNode node){
        if(node == null){
            return null;
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int max = node.val;
        int min = node.val;
        if(leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null){
            min = Math.min(min,rightData.min);
            max = Math.max(max,rightData.max);
        }

        boolean isBST = true;
        if(leftData != null && (!leftData.isBST || leftData.max >= node.val )){//左子树最大值必须严格小于根节点
            isBST = false;
        }
        if(rightData != null && (!rightData.isBST || rightData.min <= node.val)){//右子树最小值必须严格大于根节点
            isBST = false;
        }

        System.out.println(isBST);
        return new ReturnType(isBST,min,max);
    }





    //解法二：中序遍历一棵树，前一节点的值必须小于后一节点
    class Solution {
        long preValue = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            boolean checkLeft = isValidBST(root.left);
            if(!checkLeft){
                return false;
            }
            if(preValue >= root.val){//如果前一节点大于后一节点，返回false
                return false;
            }else{
                preValue = (long)root.val;
            }
            boolean checkRight = isValidBST(root.right);
            return checkRight;
        }
    }
}