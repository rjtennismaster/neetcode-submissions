class Solution {
    public int jump(int[] nums) {
        int res = 0, l = 0, r = 0;

        while (r < nums.length - 1) {
            int level = 0;
            for (int i = l; i <= r; i++) {
                level = Math.max(level, nums[i] + i);
            }

            l = r + 1;
            r = level;
            res++;
        }

        return res;
    }
}
