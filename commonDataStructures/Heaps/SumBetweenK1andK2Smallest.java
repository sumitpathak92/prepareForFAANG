package commonDataStructures.Heaps;

import java.util.PriorityQueue;

/**
 *
 * Problem : To find sum of all elements that lie between k1 smallest and k2 smallest elements in the array
 * Approach : Idea is to form a max heap and get the kth smallest element two times using same common function
 *            traverse the array later and find the sum of all elements lying between the two
 *
 * */

public class SumBetweenK1andK2Smallest {

    public static void main(String[] args) {
        int[] A = {1, 3, 12, 5, 15, 11};
        int k1 = 3; int k2 = 6;
        int f = getKthSmallest(A, k1);
        int s = getKthSmallest(A, k2);
        int sum=0;
        for(int i = 0; i < A.length; i++) {
            if(A[i]>f && A[i]<s) sum+=A[i];
        }
        System.out.println("sum is "+sum);
    }

    public static int getKthSmallest(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        for(int i : A) {
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
}
