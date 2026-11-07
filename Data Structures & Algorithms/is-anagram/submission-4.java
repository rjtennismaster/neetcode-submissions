class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for (char c : s.toCharArray())
            sFreq[c - 'a']++;
        
        for (char c : t.toCharArray())
            tFreq[c - 'a']++;
        
        return Arrays.equals(sFreq, tFreq);
    }
}
