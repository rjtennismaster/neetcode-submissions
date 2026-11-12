class Solution {
    public int subarraySum(int[] nums, int k) {
        // [sum --> frequency]
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);

        int res = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            res += seen.getOrDefault(prefixSum - k, 0);
            seen.merge(prefixSum, 1, Integer::sum);
        }

        return res;
    }
}