import java.util.Iterator;
import java.util.Map;

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
            if ((i+1) == word.length()) {
                node.values.add(val);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public TrieNode getRoot() {
        return this.root;
    }
}
