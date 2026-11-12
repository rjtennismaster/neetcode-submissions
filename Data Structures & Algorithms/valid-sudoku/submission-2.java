class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROWCOUNT = board.length, COLCOUNT = board[0].length;
        int boxH = (int) Math.sqrt(ROWCOUNT), boxW = (int) Math.sqrt(COLCOUNT);
    
        boolean[][] rows = new boolean[ROWCOUNT][COLCOUNT];
        boolean[][] cols = new boolean[ROWCOUNT][COLCOUNT];
        boolean[][] boxes = new boolean[ROWCOUNT][COLCOUNT];


        for (int r = 0; r < ROWCOUNT; r++) {
            for (int c = 0; c < COLCOUNT; c++) {
                char ch = board[r][c];

                if (ch == '.') {
                    continue;
                }

                int d = ch - '1';
                int box = (r / boxH) * boxW + (c / boxW);

                if (rows[r][d] || cols[c][d] || boxes[box][d]) {
                    return false;
                }

                rows[r][d] = true;
                cols[c][d] = true;
                boxes[box][d] = true;
            }
        }

        return true;
    }
}
