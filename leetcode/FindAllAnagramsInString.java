package leetcode;

import java.util.*;

/*
LC Medium : https://leetcode.com/problems/find-all-anagrams-in-a-string/
* **/
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String s = "abab"; String p = "ab";
        System.out.println(findAnagramsII(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return null;
        Map<Character, Integer> hm = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<p.length(); i++) {
            hm.put(p.charAt(i), hm.getOrDefault(p.charAt(i), 0)+1);
        }
        int start;
        for(int i = 0; i<=s.length()-p.length(); i++) {
            String sub = s.substring(i, i+p.length());
            Map<Character, Integer> map = new HashMap<>(hm);
            start = i; boolean flag = true;
            for(int j = 0; j<sub.length(); j++) {
                if(!map.containsKey(s.charAt(i+j))){
                    flag = false;
                    break;
                } else {
                    map.put(s.charAt(i+j), map.get(s.charAt(i+j))-1);
                }
            }
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) res.add(start);
        }
        return res;
    }

    private static List<Integer> findAnagramsII(String s, String p) {
        if(p.length()>s.length()) return new ArrayList<>();
        int[] pa = new int[26];
        int[] sa = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<p.length(); i++) {
            pa[p.charAt(i)-'a']++;
        }
        // sliding window on string s
        for(int i=0; i<s.length(); i++) {
            sa[s.charAt(i)-'a']++;
            if(i>=p.length()) {
                sa[s.charAt(i-p.length())-'a']--;
            }
            // compare array in sliding window with reference array
            if(Arrays.equals(pa, sa)) {
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}
