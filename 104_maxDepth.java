
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
    
    //解法一
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return process(root,1);
    }

    public int process(TreeNode root,int depth){
        if(root == null){
            return depth;
        }
        if(root.left != null || root.right != null){
            depth++;
            return Math.max(process(root.left,depth),process(root.right,depth));
        }
        return depth;
    }



    //解法二
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
    
}