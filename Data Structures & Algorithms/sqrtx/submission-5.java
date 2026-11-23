class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int l = 1;
        int r = x / 2;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}