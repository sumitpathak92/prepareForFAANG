package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println("stack top element :::   "+myStack.top());

        System.out.println("stack top element removed ::::   "+myStack.pop());

        System.out.println("new stack top element :::   "+myStack.top());

        System.out.println("checking if stack is empty ::::   "+myStack.empty());
    }


}

class MyStack {

    /** Initialize your data structure here. */

    private static Queue<Integer> q1;
    private static Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int s1 = q1.size()-1;
        while(s1>0) {
            q2.add(q1.remove());
            s1--;
        }
        int res = q1.remove();
        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        int s1 = q1.size()-1;
        while(s1>0) {
            q2.add(q1.remove());
            s1--;
        }
        int res = q1.remove();
        q2.add(res);
        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
