class Solution {
    List<String> part = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, 0, s);
        return res;
    }

    private void backtrack(int j, int i, String s) {
        if (i >= s.length()) {
            if (i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        // if it's a palindrome move to next part
        if (isPalindrome(j, i, s)) {
            part.add(s.substring(j, i + 1));
            backtrack(i + 1, i + 1, s);
            part.removeLast();
        }

        // if it isn't, stretch the search
        backtrack(j, i + 1, s);
    }

    private boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
