package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    public static void main(String[] args) {

    }


}

class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size()< min.size())
            max.offer(min.poll());
    }

    public double findMedian() {
        if(max.size()==min.size())
            return (double) (min.peek() + max.peek())/2.0;
        else return max.peek();
    }
}
