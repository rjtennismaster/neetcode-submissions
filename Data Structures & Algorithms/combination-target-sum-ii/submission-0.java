class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> resSet = new ArrayList<>();
        backtrack(0, candidates, target, curSet, resSet);
        return resSet;
    }

    public void backtrack(
        int i, int[] candidates, int target, List<Integer> curSet, List<List<Integer>> resSet) {
        if (target == 0) {
            resSet.add(new ArrayList<>(curSet));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        // add the num
        curSet.add(candidates[i]);
        backtrack(i + 1, candidates, target - candidates[i], curSet, resSet);
        curSet.removeLast();
        // don't add the num
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        backtrack(i + 1, candidates, target, curSet, resSet);
    }
}
