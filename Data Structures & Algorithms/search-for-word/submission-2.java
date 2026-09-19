class Solution {
    int ROWS, COLS;
    public record Pair<K, V>(K key, V value) {}
    ;
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

    private boolean backtrack(int row, int col, int i, char[][] board, String word) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= ROWS || col >= COLS
            || visited.contains(new Pair<>(row, col)) || board[row][col] != word.charAt(i)) {
            return false;
        }

        // visit the space
        visited.add(new Pair<>(row, col));

        boolean res = backtrack(row + 1, col, i + 1, board, word)
            || backtrack(row - 1, col, i + 1, board, word)
            || backtrack(row, col + 1, i + 1, board, word)
            || backtrack(row, col - 1, i + 1, board, word);

        // backtrack
        visited.remove(new Pair<>(row, col));

        return res;
    }
}