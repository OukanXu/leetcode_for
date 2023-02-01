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


//round 2
public class ReturnType{
    int depth;
    boolean isBalance;
    public ReturnType(int d, boolean is){
        depth = d;
        isBalance = is;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalance;
    }

    public ReturnType dfs(TreeNode root){
        if(root == null){
            return new ReturnType(0,true);
        }

        ReturnType leftData = dfs(root.left);
        ReturnType rightData = dfs(root.right);

        int dep = Math.max(leftData.depth,rightData.depth)+1;

        boolean isB = false;
        if(Math.abs(leftData.depth-rightData.depth) <= 1 && leftData.isBalance && rightData.isBalance){
            isB = true;
        }

        return new ReturnType(dep,isB);

    }
}


// faster
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}