package leetcode;

import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    /**
     * parameters : input string
     * return : sorted String
     *
     * @return*/
    public static String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(hm.containsKey(c)) hm.put(c, hm.get(c)+1);
            else hm.put(c, 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->(hm.get(b)-hm.get(a)));
        for(char i : hm.keySet()) {
            pq.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!pq.isEmpty()) {
            char c = pq.poll();
            int freq = hm.get(c);
            for(int i =0 ; i<freq; i++) stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
