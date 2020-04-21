package leetcode.ThirtyDaysChallenge.Week1;

import java.util.*;

/**
 * Problem : Given an array of strings, group anagrams together.
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "ate", "tea", "nat", "bat", "tan"};
        int[] m1 = {1, 0, 1, 0};
        int[] m2 = {1, 0, 1, 0};
        System.out.println("11  "+(Arrays.equals(m1, m2)));
        System.out.println("22  " + (Arrays.toString(m1)).equals(Arrays.toString(m2)));
        System.out.println("output   "+groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hm = new HashMap<>();
        for(String str : strs) {
            int[] m = new int[26];
            for(char c : str.toCharArray()) {
                m[c-'a']++;
            }
            String key = Arrays.toString(m);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
