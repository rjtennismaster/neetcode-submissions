class Solution {
    public String longestPalindrome(String s) {
        int resIndex = 0, resLength = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < dp[i].length; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i + 1 <= 3) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (resLength < j - i + 1) {
                        resIndex = i;
                        resLength = j - i + 1;
                    }
                }
            }
        }

        return s.substring(resIndex, resIndex + resLength);
    }
}
