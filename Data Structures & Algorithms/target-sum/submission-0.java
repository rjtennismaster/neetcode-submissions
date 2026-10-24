class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, target, nums, memo);
    }

    private int dfs(int i, int total, int target, int[] nums, Map<String, Integer> memo) {
        // O
        if (i >= nums.length)
            return total == target ? 1 : 0;

        // v
        String key = i + "," + total;
        if (memo.containsKey(key))
            return memo.get(key);

        // m
        memo.put(key,
            dfs(i + 1, total + nums[i], target, nums, memo)
                + dfs(i + 1, total - nums[i], target, nums, memo));

        // c
        return memo.get(key);
    }
}
