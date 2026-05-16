class PrefixTree {

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        TrieNode() {

            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public PrefixTree() {

        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode node = findNode(word);

        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    private TrieNode findNode(String str) {

        TrieNode current = root;

        for (char ch : str.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}