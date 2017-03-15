import java.util.Iterator;
import java.util.Map;

/**
 * Created by bahubali.n on 07/03/17.
 */
public class JsonBuilder {

    public static void jsonParse(TrieNode current, int numberOfSpaces) {
        if (!current.children.isEmpty()) {
            Iterator entries = current.children.entrySet().iterator();
            if (numberOfSpaces > 0) System.out.printf("%"+numberOfSpaces+"s", " ");
            System.out.print("{");
            numberOfSpaces += 4;
            while (entries.hasNext()) {
                Map.Entry thisEntry = (Map.Entry) entries.next();
                System.out.println();
                System.out.printf("%"+numberOfSpaces+"s %s", " ", thisEntry.getKey()+":");
                TrieNode node = (TrieNode) thisEntry.getValue();
                if (!node.endOfWord) {
                    System.out.println();
                    jsonParse(node, numberOfSpaces);
                }
                if (!node.values.isEmpty()) System.out.print(node.values.toString());
                System.out.printf("%"+numberOfSpaces+"s", " ");
                System.out.println();
            }
            numberOfSpaces -= 4;
            if (numberOfSpaces > 0) System.out.printf("%"+numberOfSpaces+"s", " ");
            System.out.println("}");

        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] inputs = new String[]{"A:B:C=10", "A:B:D=15", "A:B:D=20", "F=100"};
        for (int i = 0; i < inputs.length; i++) {
            String[] keyValuePair = inputs[i].split("=");
            trie.insert(keyValuePair[0].replace(":", ""), keyValuePair[1]);
        }
        JsonBuilder.jsonParse(trie.getRoot(), 0);
    }
}
