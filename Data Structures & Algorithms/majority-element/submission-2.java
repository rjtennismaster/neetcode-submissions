class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        int maj = nums.length / 2;

        for (int num : nums) {
            int count = freqs.merge(num, 1, Integer::sum);

            if (count > maj)
                return num;
        }

        return -1;
    }
}