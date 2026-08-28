class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the correct row
        int rows = matrix.length;
        int cols = matrix[0].length;
        int topRow = 0;
        int botRow = rows - 1;

        while (topRow <= botRow) {
            int midRow = (topRow + botRow) / 2;

            if (target > matrix[midRow][cols - 1]) {
                topRow = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                botRow = midRow - 1;
            } else {
                break;
            }
        }

        if (topRow > botRow) {
            return false;
        }

        // find the correct element within the row

        int l = 0;
        int r = cols - 1;
        int midRow = (topRow + botRow) / 2;

        while (l <= r) {
            int midElement = (l + r) / 2;

            if (target > matrix[midRow][midElement]) {
                l = midElement + 1;
            } else if (target < matrix[midRow][midElement]) {
                r = midElement - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
