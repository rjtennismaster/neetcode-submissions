class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            if (!mySet.add(num))
                return true;
        }

        return false;
    }
}