package commonDataStructures.Heaps;


import java.util.*;

/**
 *
 * the problem statement here is given a input array and a number X, find K closest numbers to this number in the array given K
 * Approach :  Here we will not just insert the element value into the heap, instead we will store a pair of numbers i.e <Difference, Number>
 * and will be using a Max Heap, so that number with the maximum difference goes up in the heap and we pop the item from heap each time the number of elements exceed K
 * */
public class KClosestNumbers {

    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9, }; int X = 7; int k = 3;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b)->b.getKey()-a.getKey());
        for(int i = 0; i<A.length; i++) {
            priorityQueue.offer(new AbstractMap.SimpleEntry<>(Math.abs(X-A[i]), A[i]));
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        while(!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll().getValue());
        }
        System.out.println("K closest numbers "+res.toString());
    }
}
