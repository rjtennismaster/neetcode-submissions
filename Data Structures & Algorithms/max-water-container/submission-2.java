class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            max = Math.max(max, width * height);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
