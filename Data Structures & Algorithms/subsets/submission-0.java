class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> subSets = new ArrayList<>();
        helper(0, nums, curSet, subSets);
        return subSets;
    }

    private void helper(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subSets) {
        if (i >= nums.length) {
            subSets.add(new ArrayList<>(curSet));
            return;
        }

        // add nums[i]
        curSet.add(nums[i]);
        helper(i + 1, nums, curSet, subSets);
        curSet.removeLast();

        // don't add nums[i]
        helper(i + 1, nums, curSet, subSets);
    }
}
