class Solution {
    public int longestConsecutive(int[] nums) {
        // convert arr to hashset for instant lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        // if n-1 isn't in the array, it's the start of a sequence
        int longest = 0;

        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                // find out if n+1 exists
                int length = 1;
                while (numSet.contains(length + num)) {
                    length++;
                }
                // update longest
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
