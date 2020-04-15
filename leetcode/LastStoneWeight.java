package leetcode;


import java.util.PriorityQueue;

/**
 * Problem Statement :
 *
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * */

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] A = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(A));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b)->b-a);
        for(int i : stones) {
            priorityQueue.add(i);
        }
        while(!priorityQueue.isEmpty()) {
            if(priorityQueue.size()==1) break;
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            if(x==y) {
            }
            else {
                priorityQueue.add(Math.abs(x-y));
            }
        }
        if(priorityQueue.size()==0) return 0;
        return priorityQueue.poll();
    }
}
