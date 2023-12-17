package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {

    /**
     * Array List works internally as, elements are added one by one until it is full upto its size and then the size
     * of the arrayList doubles to accommodate new elements, copies all the items in the new one and adds it
     *
     * */

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size =0;  // size is also working as an index value

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if(this.isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public int get(int idx) {
        return data[idx];
    }

    public int size() {
        return this.size;
    }

    public void set(int idx, int val) {
        data[idx] = val;
    }
    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    private void resize() {
        int[] temp = new int[data.length*2];
        for(int i = 0; i< data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
//        list.add(3);
//        list.add(5);
//        list.add(9);

        for(int i =0; i<14; i++) {
            list.add(i*2);
        }
        System.out.println(list);

        list.set(12, 13);
        System.out.println(list);

//        list.remove(0);
//
//        list.get(0);
//        list.set(0, 34);
//        list.size();
//        list.isEmpty();
    }
}
