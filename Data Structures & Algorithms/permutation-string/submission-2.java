class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int windowSize = s1.length();

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // Build initial window (indices 0 to windowSize-1)
        for (int i = 0; i < windowSize; i++) {
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check initial window
        if (Arrays.equals(s1Count, s2Count))
            return true;

        // Slide with explicit l
        int l = 0;
        for (int r = windowSize; r < s2.length(); r++) {
            s2Count[s2.charAt(r) - 'a']++;
            s2Count[s2.charAt(l) - 'a']--;

            if (Arrays.equals(s1Count, s2Count))
                return true;
            l++;
        }

        return false;
    }
}
