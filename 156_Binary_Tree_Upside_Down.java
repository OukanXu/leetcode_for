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
        
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode preFather = null;
        TreeNode preRight = null;
        while(root != null){

            TreeNode left = root.left;
            root.left = preRight;

            TreeNode right = root.right;
            root.right = preFather;

            preFather = root;
            preRight = right;

            root = left;
        }

        return preFather;
    }
}
