class Solution {
    public boolean isAnagram(String s, String t) {
        char[] freqS = new char[26];
        char[] freqT = new char[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freqT[c - 'a']++;
        }

        return Arrays.equals(freqS, freqT);
    }
}
