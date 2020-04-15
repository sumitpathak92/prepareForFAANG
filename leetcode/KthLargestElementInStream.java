package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Problem Statement:
 *
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * */

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int[] A = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, A);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap ;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for(int i = 0; i<nums.length; i++) {
            minHeap.add(nums[i]);

            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        // heap will now have k largest elements
    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
