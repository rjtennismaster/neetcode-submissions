class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            // if we guessed the target return early

            if (target == nums[m]) {
                return m;
            }

            // figure out which side is sorted
            if (nums[l] <= nums[m]) {
                // the left side is sorted, now verify target is in range
                if (target > nums[m] || target < nums[l]) {
                    // explore right
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // the right side is sorted
                if (target < nums[m] || target > nums[r]) {
                    // explore left
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }
}
