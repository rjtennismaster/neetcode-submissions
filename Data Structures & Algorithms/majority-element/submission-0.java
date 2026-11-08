class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maj = nums.length / 2;

        for (int num : nums) {
            int count = freq.merge(num, 1, Integer::sum);

            if (count > maj) {
                return num;
            }
        }

        return -1;
    }
}