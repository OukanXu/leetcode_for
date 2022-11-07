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

    public class ReturnType{
        boolean isBalance;
        int height;
        public ReturnType(boolean is, int h){
            isBalance = is;
            height = h;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return process(root).isBalance;

    }

    public ReturnType process(TreeNode root){
        if(root == null){
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);
        boolean isBalance;
        int height;
        if(leftData.isBalance && rightData.isBalance && Math.abs(leftData.height-rightData.height) <= 1){
            isBalance = true;
        }else{
            isBalance = false;
        }

        height = Math.max(leftData.height,rightData.height)+1;

        return new ReturnType(isBalance,height);
        
    }
}
