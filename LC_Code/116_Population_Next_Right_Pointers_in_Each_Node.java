/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> list = new LinkedList<>();
        list.add(root);
        int len = list.size();

        while(!list.isEmpty()){
            for(int i = 0; i < len; i++){
                Node head = list.poll();
                
                
                if(head.left != null){
                    list.add(head.left);
                }
                if(head.right != null){
                    list.add(head.right);
                }
                if(i != len-1){
                    head.next = list.peek();
                }else{
                    head.next = null;
                }
            }
            len = list.size();
        }
        return root;


    }
}


//round 2
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Node leftMost = root;
        while(leftMost.left != null){
            Node head = leftMost;
            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }   
}