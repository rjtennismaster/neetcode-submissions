class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums.length / 2;
        Map<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);

            if (freqs.get(num) > maj) {
                return num;
            }
        }

        return -1;
    }
}