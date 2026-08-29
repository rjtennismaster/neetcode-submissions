class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // one half is always sorted.
        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                // left side is sorted
                if (target > nums[mid] || target < nums[l]) {
                    // search the right side
                    l = mid + 1;
                } else {
                    // search the left side
                    r = mid - 1;
                }
            } else {
                // right side is sorted
                if (target < nums[mid] || target > nums[r]) {
                    // search the left side
                    r = mid - 1;
                } else {
                    // search the right side
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
