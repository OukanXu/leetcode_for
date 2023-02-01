/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        return builtTree(head,null);
    }


    public TreeNode builtTree(ListNode head, ListNode end){
        if(head == end){
            return null;
        }
        ListNode mid = getMedium(head,end);

        TreeNode root = new TreeNode(mid.val);
        root.left = builtTree(head,mid);
        root.right = builtTree(mid.next,end);
        return root;
    }

    public ListNode getMedium(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while(fast != right && fast.next != right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}


//round 2
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        return dfs(list,0,list.size()-1);
    }

    public TreeNode dfs(ArrayList<Integer> list, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = dfs(list,start,mid-1);
        root.right = dfs(list, mid+1,end);
        return root;
    }
}