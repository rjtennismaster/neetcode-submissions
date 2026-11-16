class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        int[] stack = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            while (top > 0 && temperatures[i] > temperatures[stack[top - 1]]) {
                int prevDayIndex = stack[--top];
                result[prevDayIndex] = i - prevDayIndex;
            }

            stack[top++] = i;
        }

        return result;
    }
}
