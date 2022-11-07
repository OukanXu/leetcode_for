//You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
//Recover the tree without changing its structure.


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
    public void recoverTree(TreeNode root) {
        //一个BST经过中序遍历之后应该为升序排列，所以先中序遍历树，如果结果为升序，返回，否则记录两个错误的节点，调换节点值

        ArrayList<TreeNode> list = new ArrayList<>();
        dfs(root,list);

        TreeNode x = null;
        TreeNode y = null;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i).val > list.get(i+1).val){
                y = list.get(i+1);
                if(x == null){
                    x = list.get(i);
                }
            }
        }

        if(x != null && y != null){
            int temp;
            temp = x.val;
            x.val = y.val;
            y.val = temp;
            
        }
       
    }

    public void dfs(TreeNode node, ArrayList<TreeNode> list){
        if(node == null){
            return;
        }
        dfs(node.left,list);
        list.add(node);
        dfs(node.right,list);
    }
}