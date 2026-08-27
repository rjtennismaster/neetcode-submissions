class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();
        int windowSize = s1.length();
        
        // Count characters in s1
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }
        
        // Build initial window in s2
        for (int i = 0; i < windowSize; i++) {
            char c = s2.charAt(i);
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
        }
        
        // Check initial window
        if (s2Count.equals(s1Count)) return true;
        
        // Slide the window
        for (int r = windowSize; r < s2.length(); r++) {
            // Add new right character
            char addChar = s2.charAt(r);
            s2Count.put(addChar, s2Count.getOrDefault(addChar, 0) + 1);
            
            // Remove left character (decrement, not remove)
            char removeChar = s2.charAt(r - windowSize);
            s2Count.put(removeChar, s2Count.get(removeChar) - 1);
            if (s2Count.get(removeChar) == 0) {
                s2Count.remove(removeChar);
            }
            
            // Check current window
            if (s2Count.equals(s1Count)) return true;
        }
        
        return false;
    }
}
