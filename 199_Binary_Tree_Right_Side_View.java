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
    public List<Integer> rightSideView(TreeNode root) {
        //相当于输出每层节点的最右侧节点
        /*
            建立一个list，存放每层最右侧节点，设置一个当前深度depth，如果depth没出现在list中，加入，depth++
         */

        int depth = 1;
        dfs(root,depth);
        return list;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }

        if(depth > list.size()){
            list.add(root.val);
        }

        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}