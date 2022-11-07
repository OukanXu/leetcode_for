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
class BSTIterator {

    private ArrayList<Integer> res;
    private int index;
    public BSTIterator(TreeNode root) {
        res = new ArrayList<Integer>();
        index = 0;
        inorder(res,root);
    }
    
    public int next() {
        
        return res.get(index++);
    }
    
    public boolean hasNext() {
        return index < res.size();
    }

    public void inorder(ArrayList<Integer> res,TreeNode root){
        if(root == null){
            return;
        }

        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */