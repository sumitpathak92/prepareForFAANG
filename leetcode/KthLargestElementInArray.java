package leetcode;

import java.util.PriorityQueue;

/*
LC Medium : https://leetcode.com/problems/kth-largest-element-in-an-array/
* **/
public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        System.out.println(findKthLargest(nums, 3));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for(int i : nums) {
            pq.add(i);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }
}
