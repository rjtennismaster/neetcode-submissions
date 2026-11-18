class Solution {
    public int majorityElement(int[] nums) {
        // count
        // find maj
        Map<Integer, Integer> counts = new HashMap<>();
        int maj = nums.length / 2;

        for (int num : nums) {
            int count = counts.merge(num, 1, Integer::sum);

            if (count > maj) {
                return num;
            }
        }

        return -1;
    }
}