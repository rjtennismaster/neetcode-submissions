class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> counts = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char c : sChars) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char tChar: tChars) {
            if (!counts.containsKey(tChar) || counts.get(tChar) == 0)
                return false;
            counts.put(tChar, counts.get(tChar) - 1);
        }

        return true;
    }
}