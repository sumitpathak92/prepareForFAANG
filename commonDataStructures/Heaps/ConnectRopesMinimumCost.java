package commonDataStructures.Heaps;

import java.util.PriorityQueue;

public class ConnectRopesMinimumCost {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr) {
            pq.add(i);
        }
        int cost=0;
        while(pq.size()>=2) {
            int first = pq.poll();
            int sec = pq.poll();
            cost+=first+sec;
            pq.add(first+sec);
        }
        System.out.println("minimum cost is "+cost);
    }
}
