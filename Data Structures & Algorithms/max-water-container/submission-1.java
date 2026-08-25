class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        // start a pointer at the left, and right
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            // get the area (l x w)
            int length = r - l;
            int width = Math.min(heights[l], heights[r]);
            int area = length * width;

            // keep updating the result at each step
            result = Math.max(result, area);

            // while the left pointer has a bigger height than the right pointer
            if (heights[l] >= heights[r]) {
                r--;
            } else {
                l++;
            }
            // decrement right pointer
            // if right is bigger than left (or they are equal), increment left pointer
            // return the result at the end
        }
        return result;
    }
}
