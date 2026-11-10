class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // make buckets (frequency --> number bucket)
        // go though top buckets --> bottom bucket till we hit k
        List<Integer>[] buckets = new List[nums.length + 1];


        Map<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> e : freqs.entrySet()) {
            int freq = e.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(e.getKey());
        }

        int[] res = new int[k];
        int indexInRes = 0;

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
