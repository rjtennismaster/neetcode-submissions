class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean canBuy, int[] prices) {
        // check if out of bounds
        if (i >= prices.length) {
            return 0;
        }

        // check if we've been here
        String key = i + "-" + canBuy;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // memory store conditions
        int cooldown = dfs(i + 1, canBuy, prices);
        if (canBuy) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            int profit = Math.max(buy, cooldown);
            memo.put(key, profit);
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i];
            int profit = Math.max(sell, cooldown);
            memo.put(key, profit);
        }

        // return memo result
        return memo.get(key);
    }
}