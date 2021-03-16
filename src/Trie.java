/**
 * Created by bahubali.n on 28/02/17.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word, String val) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        if (current.children.isEmpty()) {
            current.values.add(val);
            current.endOfWord = true;
        }
    }

    public TrieNode getRoot() {
        return this.root;
    }
}
