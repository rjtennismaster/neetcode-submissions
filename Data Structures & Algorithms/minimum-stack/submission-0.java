class MinStack {
    

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        // if we're insterting the min, add it to minstack too
        this.stack.push(val);
        if (this.minStack.isEmpty() || val <= this.minStack.peek()) {
            this.minStack.push(val);
        }
    }

    public void pop() {
        // check if we're removing the min if we want to remove from min stack

        if (this.stack.isEmpty())
            return;

        if (this.stack.pop().equals(this.minStack.peek())) {
            this.minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
