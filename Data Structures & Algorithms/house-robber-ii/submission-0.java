class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                helper(Arrays.copyOfRange(nums, 1, nums.length))));
    }

    private int helper(int[] nums) {
        int oneAgo = 0, twoAgo = 0;
        
        for (int num : nums) {
            int tmp = Math.max(oneAgo, num + twoAgo);
            twoAgo = oneAgo;
            oneAgo = tmp;
        }
        
        return oneAgo;
    }
}
