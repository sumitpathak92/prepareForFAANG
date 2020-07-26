package leetcode;

import java.util.PriorityQueue;

/**
 *
 * LC Medium : #215 https://leetcode.com/problems/kth-largest-element-in-an-array/
 * */
public class KthLargestInArray {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println("::::  output ::::  "+findKthLargest(nums, 2));
    }

    static int findKthLargest(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for(int i : A) {
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
