class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, time = 0;
        Queue<int[]> q = new LinkedList<>();
        int ROWS = grid.length, COLS = grid[0].length;

        // count freshies
        // if we run into a rotten one, add it to the queue

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        // do the bfs from the rotten fruits
        while (!q.isEmpty() && fresh > 0) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for (int[] direction : directions) {
                    // explore valid neighbors
                    int newR = r + direction[0];
                    int newC = c + direction[1];

                    if (Math.min(newR, newC) >= 0 && newR < ROWS && newC < COLS
                        && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        fresh--;
                        q.offer(new int[] {newR, newC});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
