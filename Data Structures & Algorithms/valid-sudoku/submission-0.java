class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 3 hashmaps to track what we've seen

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                // if we see a '.' continue
                if (board[row][col] == '.') {
                    continue;
                }

                String squareKey = (row / 3) + "," + (col / 3);

                if (rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) ||
                    cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[row][col])) {
                        return false;
                }

                // add the number to the sets
                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                squares.get(squareKey).add(board[row][col]);

            }
        }

        return true;
    }
}
