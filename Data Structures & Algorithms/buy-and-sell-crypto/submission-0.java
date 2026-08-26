class Solution {
    public int maxProfit(int[] prices) {
        // another sliding window
        // at each step, update maxProfit
        int maxProfit = Integer.MIN_VALUE;
        int l = 0;
        for (int r = 0; r < prices.length; r++) {
            if (r == l) {
                continue;
            }

            int profit = prices[r] - prices[l];

            // if we're not profiting, move l to r
            if (profit <= 0) {
                l = r;
            }

            // else update our max profit
            maxProfit = Math.max(profit, maxProfit);
        }

        return Math.max(maxProfit, 0);
    }
}
