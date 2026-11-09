class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }
        // buckets
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            int freq = e.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(e.getKey());
        }
        // gather

        int[] res = new int[k];

        int count = 0;

        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] == null) {
                continue;
            }

            for (int num : buckets[i]) {
                res[count++] = num;
                if (count == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
