class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helpStack;
    public MyQueue() {
        stack = new Stack<>();
        helpStack = new Stack<>();
    }
    
    public void push(int x) {
        helpStack.push(x);
    }
    
    public int pop() {
        if(stack.empty()){
            while(!helpStack.empty()){
                stack.push(helpStack.pop());
            }
        }
        return stack.pop();
    }
    
    public int peek() {
        if(stack.empty()){
            while(!helpStack.empty()){
                stack.push(helpStack.pop());
            }
        }
        return stack.peek();
    }
    
    public boolean empty() {
        return (stack.empty() && helpStack.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */