package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
 * */

public class MovingAverageImplementation {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("!!!!! ::::::    "+movingAverage.next(1));
        System.out.println("!!!!! ::::::    "+movingAverage.next(10));
        System.out.println("!!!!! ::::::    "+movingAverage.next(3));
        System.out.println("!!!!! ::::::    "+movingAverage.next(5));
    }


}

class MovingAverage {

    /** Initialize your data structure here. */
    private int s;
    private Queue<Integer> data;
    private int sum=0;
    int count = 0;
    public MovingAverage(int size) {
        s = size;
        data = new LinkedList<>();
    }

    public double next(int val) {
        count++;
        sum+=val;
        data.add(val);
        if(count<=s) {
            return (double) sum/count;
        }
        data.poll();
        Iterator<Integer> itr = data.iterator();
        int newSum = 0;
        while(itr.hasNext()) {
            newSum+=itr.next();
        }
        return (double) newSum/s;
    }
}