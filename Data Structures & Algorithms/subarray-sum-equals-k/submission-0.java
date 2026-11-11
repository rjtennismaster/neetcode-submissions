class Solution {
    public int subarraySum(int[] nums, int k) {
        // any subarray prefix sum = curr prefix sum - an earlier prefix sum
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);
        
        int prefixSum = 0;
        int res = 0;

        for (int num : nums) {
            prefixSum += num;

            res += seen.getOrDefault(prefixSum - k, 0);
            seen.merge(prefixSum, 1, Integer::sum);
        }

        return res;
    }
}