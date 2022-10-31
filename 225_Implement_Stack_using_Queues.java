class MyStack {
    private Deque<Integer> stack;


    public MyStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.addLast(x);
    }
    
    public int pop() {
        return stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
