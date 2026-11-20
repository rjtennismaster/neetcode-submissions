class Solution {
    public int subarraySum(int[] nums, int k) {
        // sum of this subarray - k = sum of past subarray --> store that past sum in map
        // sum, freq

        Map<Integer, Integer> seenSums = new HashMap<>();

        int prefixSum = 0;
        seenSums.put(prefixSum, 1);

        int res = 0;
        for (int num : nums) {
            prefixSum += num;

            int oldSum = prefixSum - k;
            res += seenSums.getOrDefault(oldSum, 0);

            seenSums.merge(prefixSum, 1, Integer::sum);
        }

        return res;
    }
}