class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int l = 0;
        int best = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (seen.containsKey(c) && seen.get(c) >= l) {
                l = seen.get(c) + 1;
            }

            seen.put(c, r);
            best = Math.max(best, r - l + 1);
        }

        return best;
    }
}
