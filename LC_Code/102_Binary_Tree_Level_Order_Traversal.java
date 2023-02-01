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

//time: beat 58.94%  memory: beat 60.69%
class Solution {
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int curDepth = 1;
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root,1);
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            int curLevel = levelMap.get(head);
            if(curLevel == curDepth){
                list.add(head.val);
            }else{
                res.add(new ArrayList<>(list));
                curDepth+=1;
                list.clear();
                list.add(head.val);
            }

            if(head.left != null){
                queue.add(head.left);
                levelMap.put(head.left,curLevel+1);
            }
            if(head.right != null){
                queue.add(head.right);
                levelMap.put(head.right,curLevel+1);
            }
        }
        res.add(new ArrayList<>(list));
        return res;

    }

}



//解法二
/*
 * 
 * 
 */

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

//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：41.8 MB, 在所有 Java 提交中击败了24.32%的用户
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }

        queue.add(root);
        int length = queue.size();
        
        while(!queue.isEmpty()){
            List<Integer> eachRow = new ArrayList<>();
            for(int i = 0; i < length; i++){
                TreeNode head = queue.poll();
                eachRow.add(head.val);

                if(head.left!= null){
                    queue.add(head.left);
                }
                if(head.right != null){
                    queue.add(head.right);
                }
            }
            res.add(eachRow);
            length = queue.size();
        }
        return res;
    }
}



//round 2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        

        Deque<TreeNode> list = new LinkedList<>();

        int tempLength = 1;

        list.add(root);

        while(!list.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < tempLength; i++){
                TreeNode node = list.pollFirst();
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
                temp.add(node.val);
            }
            res.add(temp);
            tempLength = list.size();
        }
        return res;
    }
}