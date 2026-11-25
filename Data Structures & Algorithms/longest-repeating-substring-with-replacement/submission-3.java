class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        int[] counts = new int[26];
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);
            char cl = s.charAt(l);
            counts[cr - 'A']++;
            maxFreq = Math.max(maxFreq, counts[cr - 'A']);

            // windowSize - MaxFreq <= k

            if ((r - l + 1) - maxFreq > k) {
                // shrink window
                counts[cl - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
