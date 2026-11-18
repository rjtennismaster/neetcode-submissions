class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sFreq = new char[26];
        char[] tFreq = new char[26];

        for (char c : s.toCharArray()) {
            sFreq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            tFreq[c - 'a']++;
        }

        return Arrays.equals(sFreq, tFreq);
    }
}
