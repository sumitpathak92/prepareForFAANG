package javaInterviewPrep.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private int field;
    public FilteringCondition getLambdaExp() {
        int PRICE = 2000;
        FilteringCondition lambda = hotel -> {
            this.field = 23;
            return hotel.getPricePerNight()<=PRICE;
        };
        return lambda;
    }
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        FilteringCondition lambda = hotel -> hotel.getPricePerNight()<=2000;
        List<Hotel> hotelList = hotelService.filterHotels( lambda );
                // when there is just one line of code in lambda function body then in that case we can remove
                // the curly braces and also the return statement with semicolon


        System.out.println("filtered hotel list is ::::::    "+hotelList);

        Main main = new Main();

        FilteringCondition lambdaExp = main.getLambdaExp();
        hotelService.filterHotels(lambdaExp);

        List<Integer> lst = new ArrayList<>();
        lst.add(2); lst.add(4); lst.add(21); lst.add(12);
        Collections.sort(lst, (a, b) -> {
            return b-a;
        });

        System.out.println("sorted list ::::    "+lst);



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
