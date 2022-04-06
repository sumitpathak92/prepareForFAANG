package leetcode;

import java.util.*;

/**
 * LC Medium : https://leetcode.com/problems/top-k-frequent-elements/
 * **/
public class TopKFrequentElementsII {

    public static void main(String[] args) {
        int[] A = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(A, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else
                map.put(i, 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet()); // adds all elements to max heap(this PQ implementation is for that)
        // now just get the top k elements, we will get the k max elements
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
