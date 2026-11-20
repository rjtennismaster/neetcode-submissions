class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // hold index
        int[] stack = new int[n];

        int top = 0;
        for (int i = 0; i < n; i++) {
            while (top > 0 && temperatures[i] > temperatures[stack[top - 1]]) {
                int oldTempIdx = stack[--top];
                result[oldTempIdx] = i - oldTempIdx;
            }

            stack[top++] = i;
        }

        return result;
    }
}
