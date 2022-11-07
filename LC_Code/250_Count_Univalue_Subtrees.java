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
    //count，统计是UnivalTree的数量
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return res;
        }
        check(root);
        return res;
    }

    //定义一个返回类型，包含是否为UnivalTree和子树的值
    public class ReturnType{
        private boolean isUni;
        private int val;

        public ReturnType(boolean is, int va){
            isUni = is;
            val = va;
        }
    }

    public ReturnType check(TreeNode root){

        //考虑basecase，当自己是叶子节点时的情况
        if(root.left == null && root.right == null){
            res++;
            return new ReturnType(true,root.val);
        }

        //需要判断左右子树是否存在，进行分类讨论
        if(root.left != null && root.right != null){
            ReturnType left = check(root.left);
            ReturnType right = check(root.right);

            //利用自己两个孩子的信息来组建自己的两个信息 isUnival、val
            boolean isUni = left.isUni && right.isUni && root.val == left.val && root.val == right.val;

            //如果自己是UnivalTree，就让res+1
            if(isUni){
                res++;
            }
            return new ReturnType(isUni,root.val);
        }else if(root.left != null){
            ReturnType left = check(root.left);
            boolean isUni = left.isUni && root.val == left.val;

            if(isUni){
                res++;
            }
            return new ReturnType(isUni,root.val);
        }else{
            ReturnType right = check(root.right);

            boolean isUni = right.isUni && root.val == right.val;

            if(isUni){
                res++;
            }
            return new ReturnType(isUni,root.val);
        }
        

        
    }
}
