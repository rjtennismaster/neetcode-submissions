class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int windowSize = s1.length();
        
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            s2Count[s2.charAt(r) - 'a']++;
            
            if (r - l + 1 > windowSize) {
                s2Count[s2.charAt(l) - 'a']--;
                l++;
            }
            
            if (r - l + 1 == windowSize && Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
}
