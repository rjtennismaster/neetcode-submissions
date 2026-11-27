class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int longest = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (seen.containsKey(c) && seen.get(c) >= l) {
                // shrink
                l = seen.get(c) + 1;
            }

            seen.put(c, r);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
