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
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    public int dfs(TreeNode root, List<List<Integer>> res){
        if(root == null){
            return 0;
        }

        int dep = Math.max(dfs(root.left,res),dfs(root.right,res))+1;

        if(res.size() < dep){
            res.add(new ArrayList<>());
        }

        res.get(dep-1).add(root.val);
        return dep;
    }
}