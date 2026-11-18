class Solution {
    public int evalRPN(String[] tokens) {
        // + --> add 2 pops
        // * --> mult 2 pops
        // - --> pop2 - pop1
        // / --> pop2 / pop1
        // store ints in stack

        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String t : tokens) {
            if (t.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (t.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (t.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);
            } else if (t.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}
