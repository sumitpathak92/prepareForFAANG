package leetcode;

/**
 *
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
 * */

public class MyCircularQueueImplementation {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        boolean param1 = myCircularQueue.enQueue(2);
        boolean param2 = myCircularQueue.deQueue();
        int param3 = myCircularQueue.Front();
        int param4 = myCircularQueue.Rear();
        boolean param5 = myCircularQueue.isEmpty();
        boolean param6 = myCircularQueue.isFull();
    }
}

class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if(isEmpty()) {
            head = 0;
        }
        if(isFull()) {
            return false;
        }
        tail = (tail+1)%size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        if(head==tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head=(head+1)%size;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return data[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return data[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return ((tail+1)%size)==head;
    }
}
