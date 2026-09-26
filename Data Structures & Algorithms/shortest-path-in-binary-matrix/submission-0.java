class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) {
            return -1;
        }

        int[][] visited = new int[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();

        // add 0, 0 and visit it
        q.offer(new int[2]);
        visited[0][0] = 1;

        int length = 1;
        while (!q.isEmpty()) {
            int levelLength = q.size();

            for (int i = 0; i < levelLength; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                // check if we're at the goal
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                // verify neighbors before exploring them
                int[][] neighbors = {{r + 1, c}, {r + 1, c + 1}, {r, c + 1}, {r - 1, c + 1},
                    {r - 1, c}, {r - 1, c - 1}, {r, c - 1}, {r + 1, c - 1}};

                for (int j = 0; j < neighbors.length; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];

                    if (Math.min(newR, newC) < 0 || newR >= ROWS || newC >= COLS
                        || visited[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }

                    q.offer(neighbors[j]);
                    visited[newR][newC] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}