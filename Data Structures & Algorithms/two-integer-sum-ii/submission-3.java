class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum < target) {
                l++;
            } else if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else {
                r--;
            }
        }

        return new int[] {};
    }
}
