class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int sec = stack.peek();
                int newScore = top + sec;
                stack.push(top);
                stack.push(newScore);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        for (int num : stack) {
            sum += num;
        }

        return sum;
    }
}