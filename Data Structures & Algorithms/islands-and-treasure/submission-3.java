class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // add treasure to q
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        if (q.isEmpty()) {
            return;
        }

        int wave = 1;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

            for (int i = 0; i < levelSize; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                // explore valid neighbors
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if (Math.min(nr, nc) < 0 || nr >= ROWS || nc >= COLS
                        || grid[nr][nc] != Integer.MAX_VALUE) {
                        continue;
                    }
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = wave;
                }
            }
            wave++;
        }
    }
}
