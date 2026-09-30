class Solution {
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        int[][] atl = new int[ROWS][COLS];
        int[][] pac = new int[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (atl[i][j] == 1 && pac[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int[][] ocean, int[][] heights) {
        ocean[r][c] = 1;

        // explore neighbors if they're valid

        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];

            if (Math.min(nr, nc) < 0 || nr >= heights.length || nc >= heights[0].length
                || ocean[nr][nc] == 1 || heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(nr, nc, ocean, heights);
        }
    }
}
