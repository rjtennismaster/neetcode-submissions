class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int ans = r;

        while (l <= r) {
            int cap = l + (r - l) / 2;
            boolean canShip = canShip(cap, days, weights);

            if (canShip) {
                // go lower
                ans = cap;
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }

        return ans;
    }

    private boolean canShip(int cap, int days, int[] weights) {
        int load = 0;
        int daysTaken = 1;

        for (int w : weights) {
            if (w + load > cap) {
                daysTaken++;
                load = 0;
            }

            load += w;
        }

        return daysTaken <= days;
    }
}

