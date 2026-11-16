class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minstack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (minstack.isEmpty()) {
            minstack.push(val);
        } else {
            minstack.push(Math.min(val, minstack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
