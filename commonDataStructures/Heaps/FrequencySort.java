package commonDataStructures.Heaps;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 4};
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i : nums) {
            if(hm.containsKey(i)) hm.put(i, hm.get(i)+1);
            else hm.put(i, 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)->(b.getKey()-a.getKey()));

        for(int i=0; i<nums.length; i++) {
            // TODO check this logic
            if(pq.contains(hm.values())){
            } else {
                pq.offer(new AbstractMap.SimpleEntry<>(hm.get(nums[i]), nums[i]));
            }
        }
        while(!pq.isEmpty()) {
            int freq = pq.peek().getKey();
            int elem = pq.peek().getValue();
            for(int i=0; i<freq; i++) System.out.println(elem);
            pq.poll();
        }
    }
}
