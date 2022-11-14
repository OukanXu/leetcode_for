package LC_Code;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        ArrayList<TreeNode> res = new ArrayList<>();

        dfs(res,root);
        int j = 0;
        for(int i = 0; i < res.size(); i++){
            if(res.get(i).val == p.val){
                j = i+1;
            }
        }

        if(j >= res.size()){
            return null;
        }else{
            return res.get(j);
        }
    }

    public void dfs(ArrayList<TreeNode> res, TreeNode root){
        if(root == null){
            return;
        }

        dfs(res,root.left);
        res.add(root);
        dfs(res,root.right);
    }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        if(p.right != null){
            suc = p.right;
            while(suc.left != null){
                suc = suc.left;
            }
            return suc;
        }

        TreeNode node = root;

        while(node != null){
            
            if(node.val > p.val){
                suc = node;
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return suc;
    }
}
