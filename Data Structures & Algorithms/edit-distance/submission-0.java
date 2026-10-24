class Solution {
    public int minDistance(String word1, String word2) {
        Map<String, Integer> memo = new HashMap<>();

        return dfs(0, 0, word1, word2, memo);
    }

    private int dfs(int i, int j, String word1, String word2, Map<String, Integer> memo) {
        // o
        if (i == word1.length())
            return word2.length() - j;

        if (j == word2.length())
            return word1.length() - i;
        // v
        String key = i + "," + j;
        if (memo.containsKey(key))
            return memo.get(key);
        // m
        if (word1.charAt(i) == word2.charAt(j)) {
            memo.put(key, dfs(i + 1, j + 1, word1, word2, memo));
        } else {
            int res =
                Math.min(dfs(i, j + 1, word1, word2, memo), dfs(i + 1, j, word1, word2, memo));
            res = Math.min(res, dfs(i + 1, j + 1, word1, word2, memo));
            memo.put(key, res + 1);
        }

        return memo.get(key);
    }
}
