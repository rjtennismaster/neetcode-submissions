class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int i, int j) {
        // check if out of bounds
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        // check if we've been here
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // check if we meet return condition
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dfs(text1, text2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dfs(text1, text2, i + 1, j), dfs(text1, text2, i, j + 1));
        }

        // do something else if we don't
        return memo[i][j];
    }
}
