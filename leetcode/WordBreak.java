package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LC Medium : https://leetcode.com/problems/word-break/
 * **/
public class WordBreak {

    public static void main(String[] args) {
        String s =  "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet"); wordDict.add("code");
        System.out.println(wordBreakDP(s, wordDict));
    }

    static Boolean dp[];
    public static boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return helper(s, 0, wordDict);
    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        // base case
        dp[0]=true;
        for(int i = 1;i<=s.length(); i++) {
            for(int j = 0; j<i; j++) {
                if(wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
    static boolean helper(String s, int start, List<String> wordDict) {
        if (start == s.length())
            return true;
        if(dp[start]!=null) return dp[start];
        for (int end = start+1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helper(s, end, wordDict))
                return dp[start]=true;
        }
        return dp[start]=false;
    }
}
