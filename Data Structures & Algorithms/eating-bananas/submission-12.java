class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = r;

        while (l <= r) {
            int k = l + (r - l) / 2;
            boolean canFinish = canFinish(k, h, piles);

            if (canFinish) {
                ans = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(int k, int h, int[] piles) {
        long hoursTaken = 0;

        for (int pile : piles) {
            hoursTaken += (pile + (long) (k - 1)) / k;
        }

        return hoursTaken <= h;
    }
}
