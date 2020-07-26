package leetcode;


import java.util.*;

/**
 *
 * LC Mecium : #347 https://leetcode.com/problems/top-k-frequent-elements/
 * */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2, 3, 4};
        System.out.println(topKfrequent(A, 2));
    }

    static List<Integer> topKfrequent(int[] A, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i : A)
            hm.put(i, hm.getOrDefault(i, 0)+1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(hm.entrySet());
        for(int i = 0; i<k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
