package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
LC Easy : https://leetcode.com/problems/longest-nice-substring/
* **/
public class LongestNiceSubstring {

    public static void main(String[] args) {
        String s = "c";
        System.out.println(longestNiceSubstring(s));
    }

    public static String longestNiceSubstring(String s) {
        if(s.length() == 1) return "";
        List<String> res = new ArrayList<>();
        String longest = "";
        int max=Integer.MIN_VALUE;
        for(int i =0; i<s.length(); i++) {
            int start = i;
            int end = i+1;

            while(end<s.length()) {
                String sub = s.substring(start, end+1);
//                System.out.println(sub);
                if(checkNiceHelper(sub)) {
                    if(sub.length()>max) {
                        max=sub.length();
                        longest = sub;
                    } else if(sub.length()==max){
                        // do nothing
                    }
                    res.add(sub);
                }
                end++;
            }
        }
        return longest;
    }

    private static boolean checkNiceHelper(String s) {
//        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)) {
                if(!s.contains(Character.toString(Character.toUpperCase(ch)))) {
                    return false;
                }
            } else {
                if(!s.contains(Character.toString(Character.toLowerCase(ch)))) {
                    return false;
                }
            }
        }
        return true;
    }

}
