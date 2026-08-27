class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> seenLetters = new HashSet<>();
       int l = 0;
       int longestLength = 0;
       
       for (int r = 0; r < s.length(); r++) {
           while (seenLetters.contains(s.charAt(r))) {
               seenLetters.remove(s.charAt(l));
               l++;
           }
           seenLetters.add(s.charAt(r));
           longestLength = Math.max(longestLength, r - l + 1);
       }
       
       return longestLength;
    }
}
