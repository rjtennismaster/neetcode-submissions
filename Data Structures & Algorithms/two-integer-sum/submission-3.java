class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (seen.containsKey(difference))
                return new int[]{seen.get(difference), i};
            
            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}
