class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int boxH = (int) Math.sqrt(ROWS);
        int boxW = (int) Math.sqrt(COLS);

        boolean[][] rows = new boolean[ROWS][COLS];
        boolean[][] cols = new boolean[ROWS][COLS];
        boolean[][] boxes = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char ch = board[r][c];

                if (ch == '.') {
                    continue;
                }

                int digit = ch - '1';
                int box = (r / boxH) * boxW + (c / boxW);

                if (rows[r][digit] || cols[c][digit] || boxes[box][digit]) {
                    return false;
                }

                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[box][digit] = true;
            }
        }

        return true;
    }
}
