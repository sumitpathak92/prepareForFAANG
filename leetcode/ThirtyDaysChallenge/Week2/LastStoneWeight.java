package leetcode.ThirtyDaysChallenge.Week2;

import java.util.PriorityQueue;

/**
 *
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 *
 * */

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i : stones) {
            pq.add(i);
        }
        while(!pq.isEmpty()) {
            int s = pq.poll();
            if(pq.isEmpty()) return s;
            int t = pq.poll();
            if(s!=t) pq.add(Math.abs(s-t));
        }
        return 0;
    }

}
