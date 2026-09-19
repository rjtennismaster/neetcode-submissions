class Solution {
    List<String> res = new ArrayList<>();
    String[] digitsToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String currStr, String digits) {
        if (i >= digits.length()) {
            res.add(currStr);
            return;
        }

        String chars = digitsToLetters[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()) {
            backtrack(i + 1, currStr + c, digits);
        }
    }
}
