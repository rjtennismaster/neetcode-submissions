class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sChars = new int[26];
        int[] tChars = new int[26];

        for (char c : s.toCharArray()) {
            sChars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            tChars[c - 'a']++;
        }

        return Arrays.equals(sChars, tChars);
    }
}
