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
    ArrayList<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        dfs(root);

        for(int i = 0; i < list.size()-1; i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}