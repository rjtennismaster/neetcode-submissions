class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int ans = r;

        while (l <= r) {
            int capacity = l + (r - l) / 2;
            boolean canShip = canShip(capacity, days, weights);

            if (canShip) {
                ans = capacity;
                r = capacity - 1;
            } else {
                l = capacity + 1;
            }
        }

        return ans;
    }

    private boolean canShip(int capacity, int days, int[] weights) {
        int load = 0;
        int daysTaken = 1;

        for (int w : weights) {
            if (load + w > capacity) {
                daysTaken++;
                load = 0;
            }
            load += w;
        }

        return daysTaken <= days;
    }
}