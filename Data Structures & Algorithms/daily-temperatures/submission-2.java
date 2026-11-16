class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int[] res = new int[n];


        int top = 0;
        for (int i = 0; i < n; i++) {
            while (top > 0 && temperatures[i] > temperatures[stack[top - 1]]) {
                int oldValIdx = stack[--top];
                res[oldValIdx] = i - oldValIdx;
            }

            stack[top++] = i;
        }

        return res;
    }
}
