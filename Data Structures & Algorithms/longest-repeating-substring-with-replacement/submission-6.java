class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int[] counts = new int[26];
        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            int rc = s.charAt(r) - 'A';
            int lc = s.charAt(l) - 'A';

            counts[rc]++;
            maxFreq = Math.max(maxFreq, counts[rc]);

            if ((r - l + 1) - maxFreq > k) {
                counts[lc]--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
