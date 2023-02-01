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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return new TreeNode();
        }

        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        return buildTree(nums,0,nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }

        int mid = start + (end - start)/2;

        TreeNode leftNode = buildTree(nums,start, mid-1);
        TreeNode rightNode = buildTree(nums,mid+1,end);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}


//round 2
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums,0,nums.length-1);
    }

    public TreeNode dfs(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, start, mid-1);
        root.right = dfs(nums, mid+1,end);
        return root;
    }
}