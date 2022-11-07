package LC_Code;

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
    public List<String> binaryTreePaths(TreeNode root) {      
        return dfs(root);
    }

    public List<String> dfs(TreeNode root){
        if(root.left == null && root.right == null){
            String s = Integer.toString(root.val);
            List<String> res = new ArrayList<>();
            res.add(s);
            return res;
        }

        List<String> res = new ArrayList<>();
        if(root.left != null || root.right != null){
            String str = new String(String.valueOf(root.val));
            str += "->";

            if(root.left != null){
                List<String> leftList = dfs(root.left);
                for(String s : leftList){
                    res.add(str+s);
                }
            }

            if(root.right != null){
                List<String> rightList = dfs(root.right);
                for(String s : rightList){
                    res.add(str+s);
                }
            }


        }
        return res;

    }
}
