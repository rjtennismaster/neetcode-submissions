class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> subSets = new ArrayList<>();
        backtrack(0, nums, curSet, subSets);
        return subSets;
    }

    private void backtrack(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subSets) {
        if (i >= nums.length) {
            subSets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[i]);
        backtrack(i + 1, nums, curSet, subSets);
        curSet.removeLast();

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        backtrack(i + 1, nums, curSet, subSets);
    }
}
