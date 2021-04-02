package leetcode.January2021Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CanPermutePalindrome {

    public static void main(String[] args) {
        System.out.println();
        String input = "aab";
        System.out.println(canPermutePalindromeNew(input));
    }

    public static boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(hm.containsKey(c)) {
                hm.remove(c);
            } else {
                hm.put(c, 1);
            }
        }
        if(hm.size() == 1 || hm.size() == 0) return true;
        return false;
    }

    public static boolean canPermutePalindromeNew(String s) {
        Set<Character> st = new HashSet<Character>();
        for(Character c : s.toCharArray()) {
            if(st.contains(c)) st.remove(c);
            else st.add(c);
        }
        return st.size() <= 1;
    }

}
