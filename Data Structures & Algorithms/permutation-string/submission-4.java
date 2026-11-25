class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] ct1 = new int[26];
        int[] ct2 = new int[26];

        int l = 0;

        for (int r = 0; r < s1.length(); r++) {
            ct1[s1.charAt(r) - 'a']++;
            ct2[s2.charAt(r) - 'a']++;
        }

        if (Arrays.equals(ct1, ct2)) {
            return true;
        }

        // slide right
        for (int r = s1.length(); r < s2.length(); r++) {
            ct2[s2.charAt(r) - 'a']++;
            ct2[s2.charAt(l) - 'a']--;
            l++;

            if (Arrays.equals(ct1, ct2)) {
                return true;
            }
        }

        return false;
    }
}
