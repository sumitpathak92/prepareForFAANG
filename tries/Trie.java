package tries;

public class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    // insert a word into trie
    void insertWord(String str) {
        TrieNode node = root;
        for(int i = 0; i<str.length(); i++) {
            if(!node.containsKey(str.charAt(i))){
                node.put(str.charAt(i), new TrieNode());
            }
            // move to the reference trie
            node = node.get(str.charAt(i));
        }
        node.setEnd();
    }

    boolean searchWord(String word) {
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i<prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
