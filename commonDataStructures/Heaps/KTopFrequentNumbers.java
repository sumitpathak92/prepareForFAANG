package commonDataStructures.Heaps;

import java.util.*;

/**
 *
 * Problem is to find top k frequent numbers in a given array
 * Approach : Idea is to form a min heap which will store values in the array along with their frequency
 * to store number with their frequency we will use a hash map and later add those values to the Heap
 * */

// TODO , find the bug!!

public class KTopFrequentNumbers {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i : A) {
            if(hm.containsKey(i)) {
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }
        System.out.println(hm.keySet().toString());
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        for(int i =0; i<A.length; i++) {
            priorityQueue.offer(new AbstractMap.SimpleEntry<>(hm.get(A[i]), A[i]));
            if(priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }
        System.out.println("queue values "+priorityQueue.toString());
        while(!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll().getValue());
        }
        System.out.println("K top frequent numbers are   "+res.toString());
    }
}
