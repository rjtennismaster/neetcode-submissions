class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> resSet = new ArrayList<>();
        backtrack(0, target, nums, curSet, resSet);
        return resSet;
    }

    private void backtrack(
        int i, int target, int[] nums, List<Integer> curSet, List<List<Integer>> resSet) {
        if (target == 0) {
            resSet.add(new ArrayList<>(curSet));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        // add the curr num
        curSet.add(nums[i]);
        backtrack(i, target - nums[i], nums, curSet, resSet);
        curSet.removeLast();

        // don't add the curr num
        backtrack(i + 1, target, nums, curSet, resSet);
    }
}
