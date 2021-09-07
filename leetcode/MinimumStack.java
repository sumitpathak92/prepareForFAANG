package leetcode;

import java.util.ArrayList;

/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 * */
public class MinimumStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
//        minStack.pop();

    }

}

class MinStack {

    /** initialize your data structure here. */
    private static int min = Integer.MAX_VALUE;
    private static ArrayList<int[]> al;
    public MinStack() {
        al = new ArrayList<>();
    }

    public void push(int val) {
        if(al.isEmpty()) {
            al.add(new int[]{val, val});
            return;
        }
        al.add(new int[] {val, Math.min(val, al.get(al.size()-1)[1])});
    }

    public void pop() {
        al.remove(al.size()-1);
    }

    public int top() {
        return al.get(al.size()-1)[0];
    }

    public int getMin() {
        return al.get(al.size()-1)[1];
    }
}
