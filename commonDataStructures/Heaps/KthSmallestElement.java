package commonDataStructures.Heaps;

import java.util.PriorityQueue;

/**
 *
 * for k-th smallest we need to build a max heap and return the top most element of the heap
 * Heap is constructed using priority queues in JAVA
 * */
public class KthSmallestElement {

    public static void main(String[] args) {
        int[] A = {6, 34, 12, 9, 8, 120};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y-x); //create a max heap
        for(int i=0; i<A.length; i++) {
            pq.add(A[i]); // insert elements
            if(pq.size()>k) pq.poll(); // check for heap size
        }
        System.out.println(String.format("%s th smallest is "+pq.peek(), k));
    }
}
