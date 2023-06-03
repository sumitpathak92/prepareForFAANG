package recursion;

import java.util.Arrays;

public class First {

    static int counter = 0;
    static int[] A = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        System.out.println("calling function f() :::  ");
        f(0, A.length-1);
        System.out.println("reversed array ::: "+ Arrays.toString(A));
    }

    public static void f(int l, int r) {
        if(l>=r)
            return;
        swap(l, r);
        f(l+1, r-1);
    }

    public static void swap(int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

}
