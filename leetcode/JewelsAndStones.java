package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "z";
        String S = "ZZ";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        for(char c : J.toCharArray()){
            hs.add(c);
        }
        int count = 0;
        for(char c : S.toCharArray()) {
            if(hs.contains(c)) count++;
        }
        return count;
    }
}
