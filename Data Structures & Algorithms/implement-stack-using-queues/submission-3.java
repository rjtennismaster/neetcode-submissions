class MyStack {
    Queue<Integer> stack;
    Queue<Integer> newItem;

    public MyStack() {
        newItem = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        newItem.offer(x);

        while (!stack.isEmpty()) {
            newItem.offer(stack.poll());
        }

        Queue<Integer> temp = newItem;
        newItem = stack;
        stack = temp;
    }
    
    public int pop() {
        return stack.poll();
    }
    
    public int top() {
        return stack.peek();
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