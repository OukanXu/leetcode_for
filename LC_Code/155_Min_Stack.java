class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()){
            stack.add(val);
            minStack.add(val);
        }else{
            if(val <= minStack.peekLast()){
                stack.add(val);
                minStack.add(val);
            }else{
                stack.add(val);
            }
        }
    }
    
    public void pop() {
        int temp = stack.pollLast();
        if(temp == minStack.peekLast()){
            minStack.pollLast();
        }
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}