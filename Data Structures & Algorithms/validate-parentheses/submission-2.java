class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>(Map.of(']', '[', ')', '(', '}', '{'));
        Stack<Character> charStack = new Stack<>();

        // now iterate through the string.
        // add open brackets to the stack
        // check if partner is in stack for closing brackets

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (charStack.isEmpty() || charStack.peek() != closeToOpen.get(c)) {
                    return false;
                } else {
                    charStack.pop();
                }
            } else {
                charStack.push(c);
            }
        }

        // the stack should be empty at the end of things
        return charStack.isEmpty();
    }
}
