package commonDataStructures.Heaps;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * We need to get the K largest elements in the array
 * we will use heaps minimum heap to get the numbers
 * */

public class KLargestElementsInArray {

    public static void main(String[] args) {
        int[] A = {6, 5, 55, 42, 7, 9, 33}; int k = 3;

        // using minimum heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        for(int a : A) {
            priorityQueue.add(a);
            if(priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }
        while(!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
        }
        System.out.println("answer  "+res.toString());
    }
}
