class Solution {
    public void rotate(int[] nums, int k) {
        // reverse everything
        // reverse k
        // reverse rest
        int n = nums.length;
        k = k % n;

        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    private void reverse(int l, int r, int[] nums) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            
            l++;
            r--;
        }
    }
}