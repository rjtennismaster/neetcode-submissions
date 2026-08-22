class Solution {
    public boolean isPalindrome(String s) {
        // init two pointers, l and r.
        // l is at 0 and r is at length - 1
        int l = 0;
        int r = s.length() - 1;

        // while l is less than r
        while (l < r) {
            // while l isn't alphanumeric, move it right
            while ((l < r) && !isAlphanumeric(s.charAt(l))) {
                l++;
            }

            // while r isn't alphanumeric, move it left
            while ((r > l) && !isAlphanumeric(s.charAt(r))) {
                r--;
            }
            // if l != r, it's not a palindrome

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }
        // if it is, move both l and r again
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
}
