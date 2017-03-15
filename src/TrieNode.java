import java.util.*;

/**
 * Created by bahubali.n on 28/02/17.
 */
public class TrieNode
{
    Map<Character, TrieNode> children;
    List<String> values;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
        values = new ArrayList<>();
    }
}
