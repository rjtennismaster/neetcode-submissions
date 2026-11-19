class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // skip
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            // make lowercase & compare
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            
            l++;
            r--;
        }

        return true;
    }
}
