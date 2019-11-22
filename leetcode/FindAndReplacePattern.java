package leetcode;


// DIFFICULTY : Medium

/*
* You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern.

You may return the answer in any order.

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
* */

import java.util.*;

public class FindAndReplacePattern {

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }

    private static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        // Approach 1 : using two HashMaps, keeping track of the reverse pattern map also
        for(String word : words)
            if(matchPattern(word, pattern))
                res.add(word);
        return res;
    }

    private static boolean matchPattern(String word, String pattern) {
        Map<Character, Character> hm1 = new HashMap<>();
        Map<Character, Character> hm2 = new HashMap<>();
        for(int i=0;i<word.length();i++) {
            if(!hm1.containsKey(word.charAt(i))) hm1.put(word.charAt(i), pattern.charAt(i));
            if(!hm2.containsKey(pattern.charAt(i))) hm2.put(pattern.charAt(i), word.charAt(i));
            if(!hm1.get(word.charAt(i)).equals(pattern.charAt(i)) || !hm2.get(pattern.charAt(i)).equals(word.charAt(i))) return false;
        }
        return true;
    }

}
