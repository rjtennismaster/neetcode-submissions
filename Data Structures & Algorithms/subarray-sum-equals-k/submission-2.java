class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seenSums = new HashMap<>();
        seenSums.put(0, 1);

        int prefixSum = 0;
        int res = 0;

        for (int num : nums) {
            prefixSum += num;
            res += seenSums.getOrDefault(prefixSum - k, 0);
            seenSums.merge(prefixSum, 1, Integer::sum);
        }

        return res;
    }
}