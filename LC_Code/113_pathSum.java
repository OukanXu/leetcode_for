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

/*
 * 求一棵树中从根到叶之和等于target的序列，输出为值的序列
 * 
 * 解法：
 * 建立一个双端队列path，存储已经经过的点，遍历整棵树，每到一个节点，将节点进入path，每下一层target要减去根节点的大小
 * 如果到叶子节点时target == 0， 则将path中的整个序列保存
 */


class Solution {
    List<List<Integer>> result = new LinkedList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        process(root,targetSum);
        return result;

    }

    public void process(TreeNode root, int targetSum){
        if(root == null){
            return;
        }

        path.addLast(root.val);
        targetSum = targetSum-root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            result.add(new LinkedList<>(path));
        }
        process(root.left,targetSum);
        process(root.right,targetSum);
        path.pollLast();
    }
}


//round 2
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(root,targetSum,temp,res);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> res){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null && root.val == targetSum){
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        if(root.left != null){
            temp.add(root.val);
            dfs(root.left, targetSum-root.val, temp, res);
            temp.remove(temp.size()-1);
        }

        if(root.right != null){
            temp.add(root.val);
            dfs(root.right, targetSum-root.val, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}