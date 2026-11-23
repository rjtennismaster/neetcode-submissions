class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0;
        int r = ROWS * COLS - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cell = matrix[mid / COLS][mid % COLS];

            if (cell == target) {
                return true;
            } else if (cell < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
