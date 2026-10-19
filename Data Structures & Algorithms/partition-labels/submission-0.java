class Solution {
    public List<Integer> partitionLabels(String s) {
        // map of last occurrences
        Map<Character, Integer> lastOccurrences = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrences.put(s.charAt(i), i);
        }

        int size = 0, end = 0;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastOccurrences.get(s.charAt(i)));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
