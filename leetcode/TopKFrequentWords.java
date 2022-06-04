package leetcode;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if(words.length==0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new StringComparator());
        pq.addAll(map.entrySet());
        for(int i = 0; i<k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}

class StringComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if(freq2!=freq1)
            return freq2-freq1;
        else
            return word1.compareTo(word2);
    }
}
