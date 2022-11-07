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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> list = new LinkedList<>();

        if(root == null){
            return res;
        }

        list.add(root);
        int length = list.size();
        int depth = 1;

        while(!list.isEmpty()){
            List<Integer> eachRow = new ArrayList<>();
            if(depth%2 == 1){
                for(int i = 0; i < length; i++){
                    TreeNode head = list.pollLast();
                    eachRow.add(head.val);
                    
                    if(head.left != null){
                        list.addFirst(head.left);
                    }
                    if(head.right != null){
                        list.addFirst(head.right);
                    }
                    
                }
                System.out.println(eachRow);
            }else if(depth%2 == 0){
                for(int i = 0; i < length; i++){
                    TreeNode head = list.pollFirst();
                    eachRow.add(head.val);
                    if(head.right != null){
                        list.add(head.right);
                    }
                    if(head.left != null){
                        list.add(head.left);
                    }
                    
                }
                System.out.println(eachRow);
            }
            res.add(eachRow);
            depth++;
            length = list.size();
            
        }
        return res;
    }
}
