
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
       
       return process(root.left, root.right);
    }

    public boolean process(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left != null && right == null){
            return false;
        }else if(left == null && right != null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }else{
            return process(left.left,right.right) && process(left.right, right.left);
        }



    }



    /*
     * BFS
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> list1 = new LinkedList<>();
        Queue<TreeNode> list2 = new LinkedList<>();

        list1.add(root.left);
        list2.add(root.right);

        while(!list1.isEmpty() && !list2.isEmpty()){
            TreeNode head1 = list1.poll();
            TreeNode head2 = list2.poll();
            if(head1 == null && head2 == null){
                continue;
            }
            if(head1 == null && head2 != null){
                return false;
            }
            if(head1 != null && head2 == null){
                return false;
            }
            
            if(head1.val != head2.val){
                return false;
            }

            if(head1.left == null && head2.right != null){
                return false;
            }
            if(head1.left != null && head2.right == null){
                return false;
            }
            if(head1.right == null && head2.left != null){
                return false;
            }
            if(head1.right != null && head2.left == null){
                return false;
            }

            if(head1.left != null && head2.right != null){
                list1.add(head1.left);
                list2.add(head2.right);
            }
            if(head1.right != null && head2.left != null){
                list1.add(head1.right);
                list2.add(head2.left);
            }
        }
        return list1.isEmpty() && list2.isEmpty();
    }
}
}



//round 2
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode temp1, TreeNode temp2){
        if(temp1 == null && temp2 != null){
            return false;
        }else if(temp1 != null && temp2 == null){
            return false;
        }else if(temp1 == null && temp2 == null){
            return true;
        }

        return (temp1.val == temp2.val)&& dfs(temp1.left,temp2.right)&&dfs(temp1.right, temp2.left);

    }
}