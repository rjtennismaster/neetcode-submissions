class Solution {
    public String simplifyPath(String path) {
        // split path by '/'
        // if it's empty or '.' skip
        // if it's '..' pop latest thing from stack if not empty
        // else just add text to stack

        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
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