class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curMax = 0;

        for (int num : nums) {
            curMax = Math.max(curMax, 0);
            curMax += num;
            max = Math.max(curMax, max);
        }

        return max;
    }
}
