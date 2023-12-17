package generics;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<5; i++) {
            arr.add(i+1);
        }

        Consumer<Integer> consumer = (item) -> System.out.println(item*2);
        arr.forEach(consumer);

        Operation sum = (a, b) -> a+b;
        Operation product = (a, b) -> a*b;
        Operation minus = (a, b) -> a-b;


        LambdaFunctions myCalculator =  new LambdaFunctions();
        System.out.println(myCalculator.operate(5, 3, sum));
        System.out.println(myCalculator.operate(3, 2, product));
        System.out.println(myCalculator.operate(7,3, minus));

    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
}
