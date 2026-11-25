class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> last3Seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                last3Seen.remove(nums[i - k - 1]);
            }

            if (!last3Seen.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}