package generics;

import java.util.ArrayList;
import java.util.Arrays;


// here T should either be a Number type or a subclass of Number
public class WildCardExample<T extends Number> {

    /**
     * Array List works internally as, elements are added one by one until it is full upto its size and then the size
     * of the arrayList doubles to accommodate new elements, copies all the items in the new one and adds it
     *
     * */

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size =0;  // size is also working as an index value

    public WildCardExample() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if(this.isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public T get(int idx) {
        return (T) data[idx];
    }

    public int size() {
        return this.size;
    }

    public void set(int idx, T val) {
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
        Object[] temp = new Object[data.length*2];
        for(int i = 0; i< data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove() {
        T removed = (T) data[--size];
        return removed;
    }

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        WildCardExample<Integer> list = new WildCardExample<>();
        list.add(123);
        list.add(343);

        for(int i = 0; i< 14; i++) {
            list.add(i*2);
        }

        System.out.println(list);
//        list.remove(0);
//
//        list.get(0);
//        list.set(0, 34);
//        list.size();
//        list.isEmpty();
    }
}
