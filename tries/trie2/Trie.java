package tries.trie2;

public class Trie {
    private TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for(int i =0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i)))
                return 0;
            node = node.get(word.charAt(i));
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }

}
