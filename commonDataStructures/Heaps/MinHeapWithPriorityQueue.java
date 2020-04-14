package commonDataStructures.Heaps;


import java.util.PriorityQueue;

/**
* Implementing Heap using Priority Queues in Java
* */


public class MinHeapWithPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(6);
        priorityQueue.add(9);
        priorityQueue.add(5);
        priorityQueue.add(64);
        priorityQueue.add(6);

        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()+ " ");
        }
    }

}
