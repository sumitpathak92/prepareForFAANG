//package OODDesignPatterns.com.LambdaFunctions;
//
//
//import com.sun.corba.se.spi.orb.Operation;
//
//import java.util.ArrayList;
//import java.util.function.Consumer;
//
//public class Lambda implements Operation{
//
//    public static void main(String[] args) {
//        ArrayList<Integer> A =  new ArrayList<>();
//        for(int i = 0; i<5; i++) {
//            A.add(i+1);
//        }
//
//        A.forEach((item)->{
//            System.out.println(item*2);
//        });
//
//        Consumer<Integer> fun = (item) -> System.out.println(item*2);
//        A.forEach(fun);
//
//        Operation sum = (a,b)->a+b;
//        Operation prod = (a,b)->a*b;
//    }
//
//    int sum(int a, int b) {
//        return a+b;
//    }
//}
//
//interface Operation {
//    int sum(int a, int b);
//}
