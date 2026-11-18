class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack of indexes
        // if empty stack, add the temp's index
        // if this temp > the stack top, result[i] = this temp i - stack top's i

        int n = temperatures.length;
        int[] stack = new int[n];
        int[] result = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            while (top > 0 && temperatures[i] > temperatures[stack[top - 1]]) {
                int oldVal = stack[--top];
                result[oldVal] = i - oldVal;
            }

            stack[top++] = i;
        }

        return result;
    }
}
