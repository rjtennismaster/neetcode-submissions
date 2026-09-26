class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];

        if (origColor == color) {
            return image;
        }

        dfs(image, sr, sc, origColor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int origColor, int newColor) {
        int ROWS = image.length;
        int COLS = image[0].length;

        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || image[r][c] != origColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r + 1, c, origColor, newColor);
        dfs(image, r - 1, c, origColor, newColor);
        dfs(image, r, c + 1, origColor, newColor);
        dfs(image, r, c - 1, origColor, newColor);
    }
}