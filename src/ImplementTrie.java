public class ImplementTrie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }

        node.isWord = true;
    }

    public boolean search(String word) {

        TrieNode node = find(word);

        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {

        return find(prefix) != null;
    }

    private TrieNode find(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null)
                return null;

            node = node.children[index];
        }

        return node;
    }
}
