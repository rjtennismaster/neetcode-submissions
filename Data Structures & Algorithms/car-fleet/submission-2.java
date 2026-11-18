class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // cars -> position(n), speed(2)
        // sort by closest position to target
        // for each car, push to stack if its time is slower than the current top

        int[][] cars = new int[position.length][2];

        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double[] stack = new double[cars.length];
        int top = 0;

        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];

            if (top == 0 || time > stack[top - 1]) {
                stack[top++] = time;
            }
        }

        return top;
    }
}
