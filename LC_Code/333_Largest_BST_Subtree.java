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
    public class ReturnType{
        private int count;
        private boolean isBST;
        private int max;
        private int min;

        public ReturnType(int c, boolean is, int ma, int mi){
            this.count = c;
            this.isBST = is;
            this.max = ma;
            this.min = mi;
        }
    }

    public int largestBSTSubtree(TreeNode root) {

        ReturnType data = dfs(root);
        return data == null ? 0 : data.count;
    }

    public ReturnType dfs(TreeNode root){
        if(root == null){
            return null;
        }

        ReturnType leftData = dfs(root.left);
        ReturnType rightData = dfs(root.right);

        int count = 0;
        boolean isBST = true;
        int max = root.val;
        int min = root.val;

        if(leftData != null){
            max = Math.max(max,leftData.max);
            min = Math.min(min,leftData.min);
        }

        if(rightData != null){
            max = Math.max(max,rightData.max);
            min = Math.min(min,rightData.min);
        }



        if(leftData != null && (!leftData.isBST || leftData.max >= root.val)){
            isBST = false;
        }

        if(rightData != null && (!rightData.isBST || rightData.min <= root.val)){
            isBST = false;
        }



        if(isBST){
            if(leftData != null){
                count+=leftData.count;
            }
            if(rightData != null){
                count += rightData.count;
            }
            count++;
        }else{
            if(leftData != null && rightData != null){
                count = Math.max(leftData.count,rightData.count);
            }else if(leftData == null && rightData == null){
                count++;
            }else if(leftData != null){
                count = leftData.count;
            }else if(rightData != null){
                count = rightData.count;
            }
        }
        
        System.out.println(count);
        return new ReturnType(count,isBST,max,min);

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
    public class ReturnType{
        private int size;
        private int max;
        private int min;

        public ReturnType(int size, int ma, int mi){
            this.size = size;
            this.max = ma;
            this.min = mi;
        }
    }
    public int count = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        ReturnType data = dfs(root);
        return count;
    }

    public ReturnType dfs(TreeNode root){
        if(root.left == null && root.right == null){
            count = Math.max(count,1);
            return new ReturnType(1,root.val,root.val);
        }

        boolean isBST = true;
        int max = root.val;
        int min = root.val;
        int size = 1;

        if(root.left != null){
            ReturnType leftData = dfs(root.left);
            max = Math.max(max,leftData.max);
            min = Math.min(min,leftData.min);
            if(leftData.size != -1 && root.val > leftData.max){
                size += leftData.size;
            }else{
                isBST = false;
            }
        }

        if(root.right != null){
            ReturnType rightData = dfs(root.right);
            max = Math.max(max,rightData.max);
            min = Math.min(min,rightData.min);
            if(rightData.size != -1 && root.val < rightData.min){
                size += rightData.size;
            }else{
                isBST = false;
            }
        }

        if(isBST){
            count = Math.max(count,size);
            return new ReturnType(size,max,min);
        }
        return new ReturnType(-1,max,min);
        

    }
}



