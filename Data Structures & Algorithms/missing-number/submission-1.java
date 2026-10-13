class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i <= n; i++) {
            if (i < n) {
                res = res ^ i ^ nums[i];
            } else {
                res = res ^ i;
            }
        }

        return res;
    }
}
