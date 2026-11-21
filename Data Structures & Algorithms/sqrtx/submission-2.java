class Solution {
    public int mySqrt(int x) {
        // sqrt: 1 --> x / 2
        if (x < 2) {
            return x;
        }

        int l = 1;
        int r = x / 2;
        int sqrt = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long guess = (long) mid * mid;

            if (guess == x) {
                return mid;
            } else if (guess < x) {
                sqrt = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return sqrt;
    }
}