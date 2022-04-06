package leetcode;

import java.util.*;

/**
 *
 * LC Hard : https://leetcode.com/problems/word-break-ii/
 * **/
public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = new ArrayList<>();
        dict.add("cat"); dict.add("cats"); dict.add("and"); dict.add("sand"); dict.add("dog");
        System.out.println(wordBreak(s, dict));
    }

    static Map<String, List<String>> dp;
    public static List<String> wordBreak(String s, List<String> dict) {
        Set<String> set = new HashSet<>(dict);
        List<String> res = new ArrayList<>();
        dp = new HashMap<>();
        helper(s, res, set, "");
        return res;
    }

    public static void helper(String s, List<String> res, Set<String> dict, String curr) {
        if(s.length()==0) {
            res.add(curr.substring(0, curr.length()-1));
            dp.put(s, res);
            return;
        }
        if(dp.containsKey(s)) {
            res.addAll(dp.get(s));
        }
        for(int i = 0; i<s.length(); i++) {
            String tmp = s.substring(0, i+1);
            if(dict.contains(tmp)) {
                String rem = s.substring(i+1);
                helper(rem, res, dict, curr+tmp+" ");
            }
        }
    }
}
