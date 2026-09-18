class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backtrack(0, nums);
    }

    private List<List<Integer>> backtrack(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> resPerms = new ArrayList<>();
        List<List<Integer>> currPerms = backtrack(i + 1, nums);

        for (List<Integer> perm : currPerms) {
            for (int j = 0; j < perm.size() + 1; j++) {
                List<Integer> permCopy = new ArrayList<>(perm);
                permCopy.add(j, nums[i]);
                resPerms.add(permCopy);
            }
        }

        return resPerms;
    }
}
