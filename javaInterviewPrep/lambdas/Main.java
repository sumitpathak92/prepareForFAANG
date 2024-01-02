package javaInterviewPrep.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private int field;
    public Predicate<Hotel> getLambdaExp() {
        int PRICE = 2000;
        Predicate<Hotel> lambda = hotel -> {
            this.field = 23;
            return hotel.getPricePerNight()<=PRICE;
        };
        return lambda;
    }
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        Predicate<Hotel> lambda = hotel -> hotel.getPricePerNight()<=2000;
        List<Hotel> hotelList = hotelService.filterHotels( lambda );
                // when there is just one line of code in lambda function body then in that case we can remove
                // the curly braces and also the return statement with semicolon


        System.out.println("filtered hotel list is ::::::    "+hotelList);

        Main main = new Main();

        Predicate<Hotel> lambdaExp = main.getLambdaExp();
        hotelService.filterHotels(lambdaExp);

        Predicate<Integer> divisibleBy2 = no -> no%2==0;
        Predicate<Integer> divisibleBy3 = no -> no%3==0;

        Predicate<Integer> divisibleBy6 = divisibleBy2.and(divisibleBy3);

        System.out.println("checking divisibility by 6 :::: "+divisibleBy6.test(8));


        List<Integer> lst = new ArrayList<>();
        lst.add(2); lst.add(4); lst.add(21); lst.add(12);
        Collections.sort(lst, (a, b) -> {
            return b-a;
        });

        System.out.println("sorted list ::::    "+lst);

        Consumer<Integer> consumer = a -> System.out.println(a);

        lst.forEach(consumer);

        Function<String, Boolean> strToLenMap = (string) -> string.equals("Hello world");
        Boolean length = strToLenMap.apply("Hello World");
        System.out.println(length);

        /****
         * Process to pass a function in JAVA :::
         * <p>
         * 1. Create an Interface
         * 2. Instantiate a class that implements the interface
         * 3. Implement the method of Interface, where method body is equal to function body which you want to pass
         * as a parameter
         * 4. Pass an object of concrete implementation of the interface
         * <p>
         *
         * **/

    }
}
