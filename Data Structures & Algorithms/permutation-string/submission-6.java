class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] have = new int[26];

        for (int r = 0; r < s1.length(); r++) {
            need[s1.charAt(r) - 'a']++;
            have[s2.charAt(r) - 'a']++;
        }

        if (Arrays.equals(need, have)) {
            return true;
        }

        for (int r = s1.length(); r < s2.length(); r++) {
            have[s2.charAt(r) - 'a']++;
            have[s2.charAt(r - s1.length()) - 'a']--;

            if (Arrays.equals(need, have)) {
                return true;
            }
        }

        return false;
    }
}
