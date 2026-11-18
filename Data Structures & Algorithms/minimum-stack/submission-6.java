class MinStack {
    // 2 stacks
    // maintain curr min. 
    // if new int < top of min stack, push update onto it. else just push old top

    Deque<Integer> stack;
    Deque<Integer> minstack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();    
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minstack.push(val);
        } else {
            stack.push(val);
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
