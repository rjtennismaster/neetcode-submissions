class Solution {
    public int numIslands(char[][] grid) {
        char[][] visited = new char[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c, char[][] visited) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || visited[r][c] == '1'
            || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = '1';

        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c + 1, visited);
        dfs(grid, r, c - 1, visited);
    }
}
