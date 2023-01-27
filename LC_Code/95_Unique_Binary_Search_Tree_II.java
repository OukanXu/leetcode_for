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
    
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>(null);
        }

        
        return buildTree(1,n);


    }


    public List<TreeNode> buildTree(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){

            List<TreeNode> leftTrees = buildTree(start,i-1);

            List<TreeNode> rightTrees = buildTree(i+1,end);

            for(TreeNode leftNode : leftTrees){
                for(TreeNode rightNode : rightTrees){
                    TreeNode root  = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}



//round 2
class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        
        return dfs(1,n);
    }

    public List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftNodes = dfs(start,i-1);
            List<TreeNode> rightNodes = dfs(i+1,end);

            for(TreeNode leftChild : leftNodes){
                for(TreeNode rightChild : rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    res.add(root);
                }
            }
        }
        return res;
    }
}