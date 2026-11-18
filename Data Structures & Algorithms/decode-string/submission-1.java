class Solution {
    public String decodeString(String s) {
        // counts, prevs
        // k, curr
        // parse chars. if digit, update k
        // if '[', reset
        // if ']', update level
        // if letter, just update curr

        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> prevs = new ArrayDeque<>();

        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(k);
                prevs.push(curr);

                k = 0;
                curr = new StringBuilder();
            } else if (c == ']') {
                int times = counts.pop();
                StringBuilder prev = prevs.pop();

                for (int i = 0; i < times; i++) {
                    prev.append(curr);    
                }

                curr = prev;
            } else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}