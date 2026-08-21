class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack for cold day tuples (day, index)
        Stack<int[]> stack = new Stack<>();

        // result init to 0s
        int[] result = new int[temperatures.length];


        // iterate through array
        // while it isn't empty, if the top of the cold day stack
        // is < the current day,
        // take the diff btwn curr index[i] and cold day index
        // and place that as result [i]
        // then add the curr day to the stack

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                result[stack.peek()[1]] = i - stack.pop()[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return result;
    }
}
