class Solution {
    public int maxProfit(int[] prices) {
        // another sliding window
        // at each step, update maxProfit
        int maxProfit = Integer.MIN_VALUE;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            // if we're not profiting, move l to r
            if (profit <= 0) {
                l = r;
            } else {
                // else update our max profit
                maxProfit = Math.max(profit, maxProfit);
            }
            r++;
        }

        return Math.max(maxProfit, 0);
    }
}
