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
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        int rootNum = preorder[0];
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            
            map.put(inorder[i],i);
            
        }
        pre = preorder;
        return process(0,preorder.length-1,0,inorder.length-1);
        
    }


    public TreeNode process(int preStart, int preEnd, int inStart, int inEnd){
        if(preEnd < preStart || inEnd < inStart){
            return null;
        }

        int value = pre[preStart];
        int povit = map.get(value);

        TreeNode root = new TreeNode(value);

        root.left = process(preStart+1,preStart+povit-inStart,inStart,povit-1);
        root.right = process(preEnd-inEnd+povit+1,preEnd,povit+1,inEnd);
        return root;
    }
}


//round 2
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        pre = preorder;
        return dfs(0,preorder.length-1,0,inorder.length-1);
    }


    public TreeNode dfs(int preStart,int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int value = pre[preStart];
        int rootIndex = map.get(value);

        TreeNode root = new TreeNode(value);

        root.left = dfs(preStart+1,preStart+rootIndex-inStart,inStart,rootIndex-1);
        root.right = dfs(preStart+rootIndex-inStart+1,preEnd,rootIndex+1,inEnd);

        return root;
    }
}