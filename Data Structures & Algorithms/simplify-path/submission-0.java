class Solution {
    public String simplifyPath(String path) {
        // split by '/'
        // if . or empty, skip
        // if .., check stack
        // else just add part
        // build sol

        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals("."))
                continue;

            if (part.equals("..")) {
                if (!stack.isEmpty())
                    stack.removeLast();
            } else {
                stack.addLast(part);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();

        for (String part : stack) {
            res.append("/").append(part);
        }

        return res.toString();
    }
}