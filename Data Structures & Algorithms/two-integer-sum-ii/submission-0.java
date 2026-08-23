class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // init pointers at ends
        int l = 0;
        int r = numbers.length - 1;
        // while l < r, if l + r < target, increment left
        while (l < r) {
            if ((numbers[l] + numbers[r]) < target) {
                l++;
            } else if ((numbers[l] + numbers[r]) > target) {
                r--;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }
        // if l + r > target, decrement right
        // return new int array of the indexes
        return new int[0];
    }
}
