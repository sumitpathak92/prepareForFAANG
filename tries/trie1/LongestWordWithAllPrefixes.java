package tries.trie1;

import java.util.Objects;

public class LongestWordWithAllPrefixes {

}

class TrieII {
    private TrieNode root;

    public TrieII() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }


    public static String completeString(int n, String[] a) {
        TrieII trieII = new TrieII();
        for(int i = 0; i<n; i++) {
            trieII.insert(a[i]);
        }
        String longest = "";
        for(int i = 0; i<n ; i++) {
            if(trieII.checkIfPrefixExists(a[i])){
                if(a[i].length()>longest.length())
                    longest = a[i];
                else if(a[i].length()==longest.length() && a[i].compareTo(longest)<0)
                    longest = a[i];
            }
        }
        if(Objects.equals(longest, "")) return "None";
        return longest;
    }

    private boolean checkIfPrefixExists(String s) {
        TrieNode node = root;
        boolean flag = true;
        for(int i = 0; i<s.length(); i++) {
            if(node.containsKey(s.charAt(i))){
                node = node.get(s.charAt(i));
                flag = flag& node.isEnd();
            } else
                return false;
        }
        return flag;
    }


}
