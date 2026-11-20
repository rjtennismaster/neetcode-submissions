class Solution {
    public int longestConsecutive(int[] nums) {
        // check if start. if not, ignore
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        } 

        int longest = 0;

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int length = 1;
            while (set.contains(num + length)) {
                length++;
            }

            longest = Math.max(length, longest);
        }

        return longest;
    }
}
