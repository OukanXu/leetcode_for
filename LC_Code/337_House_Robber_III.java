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
        private int steal;
        private int notSteal;

        public ReturnType(int s, int n){
            this.steal = s;
            this.notSteal = n;
        }
    }
    public int rob(TreeNode root) {
        ReturnType data = dfs(root);
        return Math.max(data.steal,data.notSteal);
    }

    public ReturnType dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return new ReturnType(root.val,0);
        }

        ReturnType leftData = null;
        ReturnType rightData = null;
        int steal = root.val;
        int notSteal = 0;

        if(root.left != null){
            leftData = dfs(root.left);
            steal += leftData.notSteal;
            notSteal += Math.max(leftData.steal,leftData.notSteal);
        }
        if(root.right != null){
            rightData = dfs(root.right);
            steal += rightData.notSteal;
            notSteal += Math.max(rightData.steal,rightData.notSteal);
        }

        return new ReturnType(steal,notSteal);
    }
}
