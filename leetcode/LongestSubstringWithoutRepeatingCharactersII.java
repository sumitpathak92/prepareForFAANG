package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * LC Medium : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * **/
public class LongestSubstringWithoutRepeatingCharactersII {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        Map<Character, Integer> set = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int start = 0; int i = 0;
        while(i<s.length()) {
            char ch = s.charAt(i);
            if(set.containsKey(ch)) {
                if(set.get(ch)>=start)
                    start = set.get(ch)+1;
            }
            set.put(ch, i);
            max = Math.max(max, i-start+1);
            i++;
        }
        return max;
    }
}
