class PrefixTree {
    PrefixTreeNode root;

    class PrefixTreeNode {
        boolean word;
        Map<Character, PrefixTreeNode> children = new HashMap<>();
    }

    public PrefixTree() {
        this.root = new PrefixTreeNode();
    }

    public void insert(String word) {
        PrefixTreeNode curr = this.root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new PrefixTreeNode());
            }
            curr = curr.children.get(c);
        }

        curr.word = true;
    }

    public boolean search(String word) {
        PrefixTreeNode curr = this.root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return curr.word;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode curr = this.root;

        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return true;
    }
}
