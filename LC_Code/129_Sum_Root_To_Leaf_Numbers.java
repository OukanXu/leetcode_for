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
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfs(root);
        int totalSum = 0;
        for(int i = 0; i < res.size(); i++){
            int partSum = 0;
            int maxTen = res.get(i).size()-1;
            for(int j = 0; j < res.get(i).size(); j++){
                partSum += res.get(i).get(j) * (Math.pow(10,maxTen));
                maxTen--;
            }
            totalSum += partSum;
        }

        return totalSum;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null){
            res.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        
        dfs(root.left);
        dfs(root.right);
        list.remove(list.size()-1);
    }
}






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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int preSum = 0;
        
        return dfs(root,preSum);
    }

    public int dfs(TreeNode root, int preSum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return preSum + root.val;
        }

        preSum = root.val * 10 + preSum * 10;
        return dfs(root.left,preSum) + dfs(root.right, preSum);
    }
}


//round 2
class Solution {
    public int res = 0;
    public int sumNumbers(TreeNode root) {
        int temp = 0;

        dfs(root,temp);
        return res;
    }

    public void dfs(TreeNode root, int temp){
        if(root.left == null && root.right == null){
            res += temp*10 + root.val;
            return;
        }

        if(root.left != null){
            dfs(root.left,temp*10+root.val);
        }
        if(root.right != null){
            dfs(root.right,temp*10+root.val);
        }   
        

    }
}