class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char lChar = Character.toLowerCase(s.charAt(l));
            char rChar = Character.toLowerCase(s.charAt(r));

            if (!Character.isLetterOrDigit(lChar)) {
                l++;
                continue;
            } else if (!Character.isLetterOrDigit(rChar)) {
                r--;
                continue;
            }

            if ((l < r) && lChar != rChar) {
                return false;
            }

            l++;
            r--; 
        }

        return true;
    }
}
