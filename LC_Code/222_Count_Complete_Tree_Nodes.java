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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        

        if(leftHeight == rightHeight){
            return (int)(Math.pow(2,leftHeight))+countNodes(root.right);
        }else{
            return (int)(Math.pow(2,rightHeight)) + countNodes(root.left);
        }
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+ getHeight(root.left);
    }
}
