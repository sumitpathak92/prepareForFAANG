package leetcode;

import java.util.*;

/**
 *
 *  problem : https://leetcode.com/problems/most-common-word/
 *
 */
public class MostCommonWord {

    public static void main(String[] args) {
        String para = "a, a, a, a, b,b,b,c, c, c";
        String[] banned = {"a"};
        System.out.println(mostCommonWord(para, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word : words) {
            if(Arrays.asList(banned).contains(word)) {
            } else {
                hm.put(word, hm.getOrDefault(word, 0)+1);
            }
        }
        return Collections.max(hm.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
