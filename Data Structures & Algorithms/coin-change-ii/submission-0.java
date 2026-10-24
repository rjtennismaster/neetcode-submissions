class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        
        for (int[] coin : memo) {
            Arrays.fill(coin, -1);
        }
        
        return dfs(0, amount, coins, memo);
    }
    
    private int dfs(int i, int amount, int[] coins, int[][] memo) {
        if (amount == 0)
            return 1;
        
        // are we in bounds
        if (i >= coins.length)
            return 0;
        // have we been here before
        if (memo[i][amount] != -1)
            return memo[i][amount];
        // meat
        int res = 0;
        if (coins[i] <= amount) {
            res = dfs(i + 1, amount, coins, memo) + dfs(i, amount - coins[i], coins, memo);
        }
        // return cache
        memo[i][amount] = res;
        
        return res;
    }
}
