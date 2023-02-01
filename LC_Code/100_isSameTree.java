
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null){
            return false;
        }
        if(p != null && q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
            BFS:建立两个队列，分别进行判断
         */

        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null){
            return false;
        }
        if(p != null && q == null){
            return false;
        }

        Queue<TreeNode> list1 = new LinkedList<>();
        Queue<TreeNode> list2 = new LinkedList<>();
        list1.add(p);
        list2.add(q);

        while(!list1.isEmpty() && !list2.isEmpty()){
            TreeNode head1 = list1.poll();
            TreeNode head2 = list2.poll();

            if(head1.val != head2.val){
                return false;
            }
            if(head1.left == null && head2.left != null){
                return false;
            }
            if(head1.left != null && head2.left == null){
                return false;
            }
            if(head1.right == null && head2.right != null){
                return false;
            }
            if(head1.right != null && head2.right == null){
                return false;
            }

            if(head1.left != null && head2.left != null){
                list1.add(head1.left);
                list2.add(head2.left);
            }
            if(head1.right != null && head2.right != null){
                list1.add(head1.right);
                list2.add(head2.right);
            }

        }

        return list1.isEmpty() && list2.isEmpty();



    }
}



//round 2
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    public boolean dfs(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null && q != null){
            return false;
        }else if(p != null && q == null){
            return false;
        }

        

        if(p.val != q.val){
            return false;
        }

        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }
}