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
        Queue<Node> list = new LinkedList<>();
        if(root == null){
            return root;
        }

        list.add(root);
        int len = list.size();
        while(!list.isEmpty()){
            
            for(int i = 0; i < len; i++){
                Node head = list.poll();
                if(i < len-1){
                    head.next = list.peek();
                }else{
                    head.next = null;
                }

                if(head.left != null){
                    list.add(head.left);
                }
                if(head.right != null){
                    list.add(head.right);
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

        Node head = root;
        Node temp = head;
        while(temp != null){
            
            Node dummy = new Node(0);
            Node cur = dummy;
            while(temp != null){
                if(temp.left != null){
                    cur.next = temp.left;
                    cur = cur.next;
                }
                if(temp.right != null){
                    cur.next = temp.right;
                    cur = cur.next;
                }
                temp = temp.next;
            }
            temp = dummy.next;
        }
        return root;
    }
}