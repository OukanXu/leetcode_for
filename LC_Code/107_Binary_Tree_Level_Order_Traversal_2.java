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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        int len = list.size();

        while(!list.isEmpty()){
            ArrayList<Integer> eachRow = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode head = list.poll();
                eachRow.add(head.val);

                if(head.left != null){
                    list.add(head.left);
                }
                if(head.right != null){
                    list.add(head.right);
                }
            }
            len = list.size();
            ans.add(new ArrayList<>(eachRow));
        }

        int length = ans.size();
        for(int i = length-1; i >= 0; i--){
            List<Integer> newOne = new ArrayList<>();
            newOne = ans.get(i);
            result.add(new ArrayList<>(newOne));
        }
        return result;
    }
}
