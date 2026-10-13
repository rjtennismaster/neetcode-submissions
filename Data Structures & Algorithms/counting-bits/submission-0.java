class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[1];
        }

        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            res[i] = numOneBits(i);
        }

        return res;
    }

    private int numOneBits(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}
