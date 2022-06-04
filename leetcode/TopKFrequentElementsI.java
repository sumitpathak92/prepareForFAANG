package leetcode;

import java.util.*;

/**
 *
 * LC Medium :  https://leetcode.com/problems/top-k-frequent-elements/
 ***/
public class TopKFrequentElementsI {

    public static void main(String[] args) {
        int[] A = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(A, 2)));
    }

    public static int[] topKFrequent(int[] A, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : A) {
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        int len = pq.size();
        for(int i = 0; i<len; i++) {
            res[i] = pq.peek().getKey();
            pq.poll();
        }
        return res;
    }
}
