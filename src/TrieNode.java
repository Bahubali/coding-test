import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bahubali.n on 28/02/17.
 */
public class TrieNode
{
    Map<Character, TrieNode> children;
    List<String> values;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        endOfWord = false;
        values = new ArrayList<String>();
    }
}
