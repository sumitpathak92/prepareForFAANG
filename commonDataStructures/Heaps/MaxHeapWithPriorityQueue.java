package commonDataStructures.Heaps;


import java.util.PriorityQueue;

/**
 *
 * max heap implementation using priority queues in JAVA
 * */


public class MaxHeapWithPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y-x);
        //insert values in the queue
        priorityQueue.add(5);
        priorityQueue.add(8);
        priorityQueue.add(22);
        priorityQueue.add(2);
        priorityQueue.add(33);

        priorityQueue.poll();
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()+ " ");
        }
    }
}
