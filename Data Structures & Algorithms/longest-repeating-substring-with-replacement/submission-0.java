class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> letters = new HashSet<>();
        int result = 0;

        for (char c : s.toCharArray()) {
            letters.add(c);
        }

        for (char c : letters) {
            int l = 0;
            int count = 0;

            for (int r = 0; r < s.length(); r++) {
                // update count first
                if (s.charAt(r) == c) {
                    count++;
                }

                // if invalid window, shift l

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c)
                        count--;
                    l++;
                }

                // update result w/ size of the window
                result = Math.max(result, r - l + 1);
            }
        }
        return result;
    }
}
