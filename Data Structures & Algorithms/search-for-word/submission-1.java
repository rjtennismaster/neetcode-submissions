class Solution {
    public record Pair<K, V>(K key, V value) {}
    ;
    int ROWS, COLS;
    Set<Pair<Integer, Integer>> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (backtrack(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int r, int c, int i, char[][] board, String word) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited.contains(new Pair<>(r, c))
            || board[r][c] != word.charAt(i)) {
            return false;
        }

        Pair<Integer, Integer> newPair = new Pair<>(r, c);
        visited.add(newPair);
        boolean res = backtrack(r + 1, c, i + 1, board, word)
            || backtrack(r - 1, c, i + 1, board, word) || backtrack(r, c + 1, i + 1, board, word)
            || backtrack(r, c - 1, i + 1, board, word);
        visited.remove(newPair);
        return res;
    }
}