class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // zip the arrays into a double array of pairs
        int[][] posSpeedPairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            posSpeedPairs[i][0] = position[i];
            posSpeedPairs[i][1] = speed[i];
        }
        // sort the array in descending order wrt position
        Arrays.sort(posSpeedPairs, (a, b) -> Integer.compare(b[0], a[0]));
        // for each pair, store time in stack
        Stack<Double> times = new Stack<>();

        for (int[] p : posSpeedPairs) {
            double time = ((double) (target - p[0]) / p[1]);
            times.push(time);

            // if top of stack is less or eq to 2nd in stack, then pop it
            if (times.size() >= 2 && times.peek() <= times.get(times.size() - 2)) {
                times.pop();
            }
        }

        return times.size();
    }
}
