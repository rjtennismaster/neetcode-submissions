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
        stack.push(val);

        if (minstack.isEmpty()) {
            minstack.push(val);
        } else {
            minstack.push(Math.min(minstack.peek(), val));
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
