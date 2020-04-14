package commonDataStructures.Heaps;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * sorting a nearly sorted or k-sorted array using a heap
 *
 * nearly sorted or k-sorted means element at index i is to be found in range [i-k, i+k]
 *
 * */

public class SortAKSortedArray {

    public static void main(String[] args) {
        int[] A = {6, 5, 3, 2, 8, 10, 9}; int k = 3;

        // using a min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<A.length; i++) {
            priorityQueue.add(A[i]);
            if(priorityQueue.size()>k) res.add(priorityQueue.poll());
        }
        while(!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
        }
        System.out.println("sorted array  "+res.toString());
    }
}
