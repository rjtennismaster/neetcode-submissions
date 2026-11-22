class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum < target) {
                l++;
            } else if (sum == target) {
                return new int[] {1 + l, 1 + r};
            } else {
                r--;
            }
        }

        return new int[] {};
    }
}
