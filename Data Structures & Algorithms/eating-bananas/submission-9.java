class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = r;

        while (l <= r) {
            int k = l + (r - l) / 2;

            if (canFinish(k, h, piles)) {
                ans = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(int k, int h, int[] piles) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long) k - 1) / k;
        }

        return hours <= h;
    }
}
