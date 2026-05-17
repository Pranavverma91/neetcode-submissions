class WordDictionary {
    // Trie Node
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word into Trie
    public void addWord(String word) {
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

    // Search word with '.' wildcard
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        // Reached end of word
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        // Wildcard '.'
        if (ch == '.') {
            // Try all possible characters
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        // Normal character
        int childIndex = ch - 'a';

        if (node.children[childIndex] == null) {
            return false;
        }

        return dfs(word, index + 1, node.children[childIndex]);
    }
}