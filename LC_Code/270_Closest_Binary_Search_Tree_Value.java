package LC_Code;

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
        public int val;
        public double min;

        public ReturnType(int v, double m){
            val = v;
            min = m;
        }
    }


    public int closestValue(TreeNode root, double target) {


        ReturnType data = dfs(root,target);
        return data.val;
    }

    public ReturnType dfs(TreeNode root, double target){
        if(root== null){
            return null;
        }

        ReturnType leftData = dfs(root.left,target);
        ReturnType rightData = dfs(root.right,target);


        double min = Math.abs((double)root.val-target);
        int val = root.val;

        if(leftData != null){
            min = Math.min(min,leftData.min);
            val = min == leftData.min ? leftData.val : val;
        }

        if(rightData != null){
            min = Math.min(min,rightData.min);
            val = min == rightData.min ? rightData.val : val;
        }

        return new ReturnType(val,min);
    }

    
}
