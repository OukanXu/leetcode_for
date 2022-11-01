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
    
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        getRes(root,k,res);
        return res.get(k-1);
    }

    public void getRes(TreeNode root, int k, ArrayList<Integer> res){

        if(res.size() == k){
            return;
        }
        if(root == null){
            return;
        }

        getRes(root.left,k,res);
        if(res.size() == k){
            return;
        }else{
            res.add(root.val);
        }
        getRes(root.right,k,res);
    }
}