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
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        dfs(root);
        return list;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}


//round 2
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root,list);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}