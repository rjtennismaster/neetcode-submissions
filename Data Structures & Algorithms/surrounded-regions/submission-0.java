class Solution {
    int[][] directions;
    int ROWS, COLS;

    public void solve(char[][] board) {
        directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        ROWS = board.length;
        COLS = board[0].length;

        // #1 find non surrounded O --> T
        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                capture(r, 0, board);
            }

            if (board[r][COLS - 1] == 'O') {
                capture(r, COLS - 1, board);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                capture(0, c, board);
            }

            if (board[ROWS - 1][c] == 'O') {
                capture(ROWS - 1, c, board);
            }
        }

        // #2 O --> X
        // #3 T --> O

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void capture(int r, int c, char[][] board) {
        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];

            capture(nr, nc, board);
        }
    }
}
