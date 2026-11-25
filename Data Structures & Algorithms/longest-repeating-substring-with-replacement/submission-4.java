class Solution {
    public int characterReplacement(String s, int k) {
        // count the max freq of what's in the window as it grows
        // take action if windowSize - maxFreq > k

        int l = 0;
        int[] counts = new int[26];
        int maxFreq = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            char lc = s.charAt(l);

            counts[rc - 'A']++;
            maxFreq = Math.max(maxFreq, counts[rc - 'A']);

            if ((r - l + 1) - maxFreq > k) {
                // shrink window, get rid of left
                counts[lc - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
