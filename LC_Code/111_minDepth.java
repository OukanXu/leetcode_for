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
    //写法一
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 1;
        
        return process(root,depth);
    }

    public int process(TreeNode root, int depth){
        if(root.left == null && root.right == null){
            return depth;
        }
        if(root.left == null){
            return process(root.right,depth+1);
        }
        if(root.right == null){
            return process(root.left,depth+1);
        }

        return Math.min(process(root.left,depth+1),process(root.right,depth+1));
    }

    //写法二
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            int L = minDepth(root.left);
            int R = minDepth(root.right);
            if(L==0) return R + 1;
            else if (R==0) return L + 1;
            else return Math.min(L, R) + 1;
        }
    }
}
