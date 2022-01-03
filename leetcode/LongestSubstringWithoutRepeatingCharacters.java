package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
LC medium : https://leetcode.com/problems/longest-substring-without-repeating-characters/
* **/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String ip = "aaaa";
        System.out.println(lengthOfLongestSubstring(ip));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int i = 0; int start = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hs = new HashMap<>();
        while(i<s.length()) {
            char c = s.charAt(i);
            if(hs.containsKey(c)) {
                if(hs.get(c) >= start) {
                    start = hs.get(c)+1;
                }
            }
            max = Math.max(max, i-start+1);
            hs.put(c, i);
            i++;
        }
        return max;
    }

}
