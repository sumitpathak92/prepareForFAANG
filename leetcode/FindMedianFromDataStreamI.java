package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStreamI {

    public static void main(String[] args) {

    }


}

class MedianFinderI {

    PriorityQueue<Integer> minHeap; // declare a min heap
    PriorityQueue<Integer> maxHeap;

    public MedianFinderI() {
        minHeap = new PriorityQueue<>(); // declare a min heap
        maxHeap = new PriorityQueue<>((a, b)->(b-a));// declare a max heap,
        // by default incoming element will be added to maxHeap
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if(minHeap.size()>0 && maxHeap.size()>0 && maxHeap.peek()>minHeap.peek()) {
            int val = maxHeap.remove();
            minHeap.add(val);
        }
        // check for uneven size
        if(maxHeap.size()-minHeap.size()>1) {
            int val = maxHeap.remove();
            minHeap.add(val);
        }
        else if(minHeap.size()-maxHeap.size()>1) {
            int val = minHeap.remove();
            maxHeap.add(val);
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }if(minHeap.size()>maxHeap.size()) {
            return minHeap.peek();
        }
        return (minHeap.poll()+ maxHeap.poll())/2.0;
    }

}
