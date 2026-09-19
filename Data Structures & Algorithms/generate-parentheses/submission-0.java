class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(0, 0, n, builder, resList);
        return resList;
    }

    private void backtrack(
        int open, int closed, int n, StringBuilder builder, List<String> resList) {
        if (open == closed && open == n) {
            resList.add(builder.toString());
            return;
        }

        if (open < n) {
            builder.append('(');
            backtrack(open + 1, closed, n, builder, resList);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (closed < open) {
            builder.append(')');
            backtrack(open, closed + 1, n, builder, resList);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
