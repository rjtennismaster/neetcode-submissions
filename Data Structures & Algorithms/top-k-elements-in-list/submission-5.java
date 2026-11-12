class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // get frequencies of numbers [nums -> freq]
        // put nums in buckets [freq -> num bucket]
        // nav in reverse thru buckets till k

        Map<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> e : freqs.entrySet()) {
            int freq = e.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(e.getKey());
        }

        int indexInRes = 0;
        int[] res = new int[k];

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }

            for (int num : buckets[i]) {
                res[indexInRes++] = num;

                if (indexInRes == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
