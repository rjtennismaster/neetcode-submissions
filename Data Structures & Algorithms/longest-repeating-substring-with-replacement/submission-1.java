class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int longest = 0;
        int maxFreq = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            // add char to window, counts
            counts[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(r) - 'A']);

            // we need windowSize - maxFreq <= k
            if ((r - l + 1) - maxFreq > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
