class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        Map<String, Boolean> memo = new HashMap<>();

        return dfs(0, 0, 0, s1, s2, s3, memo);
    }

    private boolean dfs(
        int i, int j, int k, String s1, String s2, String s3, Map<String, Boolean> memo) {
        // o
        if (k >= s3.length())
            return (i >= s1.length() && j >= s2.length());
        // v
        String key = i + "," + j;
        if (memo.containsKey(key))
            return memo.get(key);
        // m
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            res = dfs(i + 1, j, k + 1, s1, s2, s3, memo);

        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res = dfs(i, j + 1, k + 1, s1, s2, s3, memo);
        // c
        memo.put(key, res);
        return res;
    }
}
