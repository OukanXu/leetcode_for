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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> widQueue = new LinkedList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();

        queue.add(root);
        widQueue.add(0);
        while(!queue.isEmpty()){
            int m = queue.size();
            for(int i = 0; i < m; i++){
                TreeNode tempNode = queue.poll();
                int tempWid = widQueue.poll();
                if(!map.containsKey(tempWid)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(tempNode.val);
                    map.put(tempWid,temp);
                }else{
                    List<Integer> temp = map.get(tempWid);
                    temp.add(tempNode.val);
                    map.put(tempWid,temp);
                }
                if(tempNode.left != null){
                    queue.add(tempNode.left);
                    widQueue.add(tempWid-1);
                }
                if(tempNode.right != null){
                    queue.add(tempNode.right);
                    widQueue.add(tempWid+1);
                }
            }
        }

        
        return new ArrayList<>(map.values());
    }
}