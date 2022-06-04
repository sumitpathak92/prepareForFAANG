package tries.trie2;

public class TrieNode {

    TrieNode[] links = new TrieNode[26];
    int cntEndWith = 0;
    int cntPrefix = 0;

    public TrieNode() {

    }

    boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }

    TrieNode get(char ch) {
        return links[ch-'a'];
    }

    void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }

    void increaseEnd() {
        this.cntEndWith++;
    }

    void increasePrefix() {
        this.cntPrefix++;
    }

    void deleteEnd() {
        this.cntEndWith--;
    }

    void reducePrefix() {
        this.cntPrefix--;
    }

    int getEnd() {
        return this.cntEndWith;
    }

    int getPrefix() {
        return this.cntPrefix;
    }
}
