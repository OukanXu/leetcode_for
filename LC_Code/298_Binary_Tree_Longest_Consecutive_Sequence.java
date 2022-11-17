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
    public int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int lengthLeft = 1;
        int lengthRight = 1;

        if(left != 0 && root.val + 1 == root.left.val){
            lengthLeft = left+1;
        }

        if(right != 0 && root.val + 1 == root.right.val){
            lengthRight = right + 1;
        }

        max = Math.max(max,Math.max(lengthLeft,lengthRight));
        return Math.max(lengthLeft,lengthRight);
    }
}
