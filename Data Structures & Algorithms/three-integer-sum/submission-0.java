class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // seed one value and find the other two
        for (int i = 0; i < nums.length; i++) {
            // if the seed is already greater than 0, we don't need to continue
            if (nums[i] > 0)
                break;
            // check for duplicate on seed
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // do the twosum for the subproblem to the right to find the other 2 indexes
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0)
                    l++;
                else if (sum > 0)
                    r--;
                else {
                    // add the triplet to the result list
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    // move l and r inward
                    l++;
                    r--;
                    // check for dupes on the left
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }
        return result;
    }
}
