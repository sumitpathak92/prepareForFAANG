package leetcode;

import java.util.Stack;

/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
 * */
public class ImplementQueueUsingStack {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        System.out.println("front element ::::   "+ myQueue.peek());

        System.out.println("remove front element ::::   "+myQueue.pop());
        System.out.println("new front element ::::   "+ myQueue.peek());
        System.out.println("checking if empty ::::   "+myQueue.empty());
    }


}

class MyQueue {

    /** Initialize your data structure here. */

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res;
        while(!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        res = s2.pop();
        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        int res;
        while(!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        res = s2.peek();
        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}