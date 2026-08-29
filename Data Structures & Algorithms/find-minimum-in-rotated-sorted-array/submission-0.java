class Solution {
    public int findMin(int[] nums) {
        // to deduce, look at the base case (only way, too confusing)
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
