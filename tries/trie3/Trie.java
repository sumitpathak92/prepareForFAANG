package tries.trie3;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int countDistinctSubstrings(String s) {
        int count = 0;
        TrieNode root = new TrieNode();
        for(int i = 0; i<s.length(); i++) {
            TrieNode node = root;
            for(int j = i; j<s.length(); j++) {
                if(!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new TrieNode());
                    count++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return count+1;
    }
}
