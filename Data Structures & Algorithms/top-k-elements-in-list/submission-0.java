class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count the frequencies of the numbers
        Map<Integer, Integer> count = new HashMap<>();
        // frequency array of lists
        List<Integer>[] freq = new List[nums.length + 1];
        // init the lists
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // populate the map with frequencies
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // populate the lists in the freq array
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        // init result array
        int[] result = new int[k];
        // init result index
        int resultIndex = 0;
        // populate result array
        for (int i = freq.length - 1; i > 0 && resultIndex < k; i--) {
            // add the numbers in each list to the result till we run out of space to add
            for (int n: freq[i]) {
                result[resultIndex++] = n;

                if (resultIndex == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
