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
 * 已知一颗树的中序遍历数组和后序遍历数组，求重新构建这颗树，并返回根节点
 * 
 * 解法：根据后序遍历数组求得整棵树的根节点（数组最后一位）， 根据根节点在中序数组中划分出两个部分，根节点前为左子树，后为右子树
 * 重复上述操作，就可以获得整棵树
 * 
 */
class Solution {
    
    HashMap<Integer,Integer> inHash = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            inHash.put(inorder[i],i);
        }

        post = postorder; 
        return process(0,inorder.length-1,0,postorder.length-1);

    }

    public TreeNode process(int inStart, int inEnd, int postStart, int postEnd){
        if(inEnd < inStart || postEnd < postStart){
            return null;
        }

        int value = post[postEnd];
        TreeNode root = new TreeNode(value);

        int povit = inHash.get(value);//获得分界点在inorder序列的坐标

        //重新获取四个参数
        root.left = process(inStart,povit-1,postStart,postStart+povit-1-inStart);
        root.right = process(povit+1,inEnd,postStart+povit-inStart,postEnd-1);
        return root;
    }
}


//round 2
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return dfs(0,inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode dfs(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        int value = post[postEnd];
        int rootIndex = map.get(value);

        TreeNode root = new TreeNode(value);

        root.left = dfs(inStart,rootIndex-1,postStart,postStart+rootIndex-inStart-1);
        root.right = dfs(rootIndex+1,inEnd,postEnd-(inEnd-rootIndex),postEnd-1);
        return root;
    }
}