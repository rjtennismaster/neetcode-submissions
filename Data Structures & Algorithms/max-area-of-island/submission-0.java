class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    area = Math.max(area, dfs(grid, i, j, visited));
                }
            }
        }

        return area;
    }

    private int dfs(int[][] grid, int r, int c, int[][] visited) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || visited[r][c] == 1 || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = 1;
        int thisArea = 1;

        thisArea += dfs(grid, r + 1, c, visited);
        thisArea += dfs(grid, r - 1, c, visited);
        thisArea += dfs(grid, r, c + 1, visited);
        thisArea += dfs(grid, r, c - 1, visited);

        return thisArea;
    }
}
