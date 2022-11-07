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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);

        while(!list.isEmpty()){
            TreeNode head = list.poll();

        
                TreeNode temp;
                temp = head.left;
                head.left = head.right;
                head.right = temp;


            if(head.left != null){
                list.add(head.left);
            }
            if(head.right != null){
                list.add(head.right);
            }
        }
        return root;
    }
}